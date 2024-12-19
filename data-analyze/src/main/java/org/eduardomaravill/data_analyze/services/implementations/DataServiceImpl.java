package org.eduardomaravill.data_analyze.services.implementations;

import lombok.extern.log4j.Log4j2;
import org.eduardomaravill.data_analyze.dtos.RequestLink;
import org.eduardomaravill.data_analyze.dtos.ResponseLink;
import org.eduardomaravill.data_analyze.models.FileRecord;
import org.eduardomaravill.data_analyze.models.Link;
import org.eduardomaravill.data_analyze.services.IDataService;
import org.eduardomaravill.data_analyze.services.IFileRecordService;
import org.eduardomaravill.data_analyze.services.ILinkService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Log4j2
public class DataServiceImpl implements IDataService {

    private final ILinkService linkService;
    private final IFileRecordService fileRecordService;
    private final FileDownloaderService fileDownloaderService;

    @Autowired
    public DataServiceImpl(ILinkService linkService, IFileRecordService fileRecordService, FileDownloaderService fileDownloaderService) {
        this.linkService = linkService;
        this.fileRecordService = fileRecordService;
        this.fileDownloaderService = fileDownloaderService;
    }

    @Override
    public List<ResponseLink> getDataLinks(RequestLink requestLink) {
        List<Link> links = scrapeLinks(requestLink.getUrl());
        links = new ArrayList<>(linkService.saveLinks(links));
        return links.stream().map(link -> new ResponseLink(link.getId(),link.getDownloadUrl())).toList();
    }

    @Override
    public void downloadDataFiles() {
        List<FileRecord> fileRecords = fileRecordService.downloadDataFiles();
        fileDownloaderService.downloadFilesInParallel(fileRecords);
    }

    @Override
    public void generateRecords() {
      List<Link> links = linkService.getLinks();
      fileRecordService.createFileRecords(links);
    }

    private List<Link> scrapeLinks(String url) {
        try {
            log.info("Start Scrapping data");
            Document document = Jsoup.connect(url).get(); //Get the document of Url
            Elements rows = document.select("tr.__dt_row"); //Select Rows
            List<Link> links = new ArrayList<>();
            for (Element row : rows) {
                extractedLinks(row, links);
            }
            log.info("Finish Scrapping data");
            return links;
        }catch (IOException e){
            log.error("❌ Error al conectar con la URL: {}", e.getMessage());
        }
        return Collections.emptyList();
    }

    private static void extractedLinks(Element row, List<Link> links) {
        try {
            String title = row.select("td.__dt_col_0 strong").text();
            String dateCreated = row.select("td.__dt_col_2 span.__dt_update_date").text();
            String downloadUrl = row.select("td.__dt_col_3 a.wpdm-download-link").attr("data-downloadurl");
            Link link = new Link();
            link.setTitle(title);
            link.setDateCreated(dateCreated);
            link.setDownloadUrl(downloadUrl);
            links.add(link);
        }catch (Exception e){
            log.error("�� Error al extraer datos de la fila: {}", e.getMessage());
        }
    }
}
