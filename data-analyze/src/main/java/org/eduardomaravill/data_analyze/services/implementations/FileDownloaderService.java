package org.eduardomaravill.data_analyze.services.implementations;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.eduardomaravill.data_analyze.models.FileRecord;
import org.eduardomaravill.data_analyze.services.IFileRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Service
@Log4j2
public class FileDownloaderService {

    private final WebClient webClient;
    private final IFileRecordService fileRecordService;
    private final String downloadPath;

    @Autowired
    public FileDownloaderService(WebClient webClient, IFileRecordService fileRecordService) {
        this.webClient = webClient;
        this.fileRecordService = fileRecordService;
        this.downloadPath = Paths.get("src", "main", "resources", "documents").toAbsolutePath().toString();
        log.info("Archivos se guardarán en la carpeta: {}", this.downloadPath);
    }

    /**
     * Descarga múltiples archivos de forma paralela.
     *
     * @param fileRecords Lista de Links con los archivos PDF a descargar.
     */
    @Transactional
    public void downloadFilesInParallel(List<FileRecord> fileRecords) {
        Flux.fromIterable(fileRecords)
                .flatMap(this::downloadFile)
                .doOnError(error -> log.error("Error en la descarga: {}", error.getMessage()))
                .subscribe();
    }

    /**
     * Descarga un archivo y lo guarda en la ruta especificada.
     *
     * @param fileRecord Objeto Link con la URL y metadatos del archivo.
     * @return Mono<Void> que representa la tarea asíncrona.
     */
    private Mono<Void> downloadFile(FileRecord fileRecord) {
        String fileName = extractFileNameFromUrl(fileRecord);
        String fullPath = Paths.get(downloadPath, fileName).toString();

        log.info("Descargando: {} => {}", fileRecord.getLink().getDownloadUrl(), fullPath);

        return webClient.get()
                .uri(fileRecord.getLink().getDownloadUrl())
                .retrieve()
                .bodyToMono(byte[].class)
                .flatMap(bytes -> saveFile(fullPath, bytes,fileRecord));
    }

    /**
     * Extrae el nombre de archivo de la URL.
     *
     * @param fileRecord Link con el título y la fecha de creación.
     * @return Nombre de archivo limpio.
     */
    private String extractFileNameFromUrl(FileRecord fileRecord) {
        return fileRecord.getLink().getTitle()
                .trim()
                .replaceAll("[^a-zA-Z0-9-_]", "_") // Reemplaza caracteres especiales
                + "-" + fileRecord.getLink().getDateCreated().trim().replaceAll("\\s+", "-") + ".pdf";
    }

    /**
     * Guarda los bytes de un archivo.
     *
     * @param filePath Ruta completa donde se guardará el archivo.
     * @param bytes Contenido binario del archivo.
     * @param fileRecord Contenido binario del archivo.
     * @return Mono<Void> que representa la tarea de guardado.
     */
    private Mono<Void> saveFile(String filePath, byte[] bytes, FileRecord fileRecord) {
        return Mono.fromRunnable(() -> {
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                outputStream.write(bytes);
                fileRecord.setDownload(true);
                fileRecord.setPath(filePath);
                fileRecordService.updateFileRecords(fileRecord);
                log.info("Archivo guardado: {}", filePath);
            } catch (IOException e) {
                log.error("Error al guardar el archivo: {}", e.getMessage());
            }
        });
    }
}