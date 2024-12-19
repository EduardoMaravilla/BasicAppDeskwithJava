package org.eduardomaravill.data_analyze.services;

import org.eduardomaravill.data_analyze.models.FileRecord;
import org.eduardomaravill.data_analyze.models.Link;

import java.util.List;

public interface IFileRecordService {

    void createFileRecord(Link link);
    void createFileRecords(List<Link> links);
    void updateFileRecords(FileRecord fileRecord);

    List<FileRecord> downloadDataFiles();
}
