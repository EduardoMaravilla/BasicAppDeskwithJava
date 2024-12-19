package org.eduardomaravill.data_analyze.services.implementations;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.eduardomaravill.data_analyze.models.FileRecord;
import org.eduardomaravill.data_analyze.models.Link;
import org.eduardomaravill.data_analyze.repository.IFileRecordRepository;
import org.eduardomaravill.data_analyze.services.IFileRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class FileRecordServiceImpl implements IFileRecordService {

    private final IFileRecordRepository fileRecordRepository;

    @Autowired
    public FileRecordServiceImpl(IFileRecordRepository fileRecordRepository) {
        this.fileRecordRepository = fileRecordRepository;
    }

    @Override
    @Transactional
    public void createFileRecord(Link link) {
        if (!fileRecordRepository.existsByLink(link)){
            fileRecordRepository.save(new FileRecord(null,link,false,false,""));
            log.info("File Record Created for Link: {}", link.getTitle());
        }

    }

    @Override
    public void createFileRecords(List<Link> links) {
       for(Link link : links) {
           createFileRecord(link);
       }
    }

    @Override
    @Transactional
    public void updateFileRecords(FileRecord fileRecord) {
        fileRecordRepository.save(fileRecord);
    }

    @Override
    public List<FileRecord> downloadDataFiles() {
        return fileRecordRepository.findAllByIsDownloadFalse();
    }
}
