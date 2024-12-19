package org.eduardomaravill.data_analyze.repository;

import org.eduardomaravill.data_analyze.models.FileRecord;
import org.eduardomaravill.data_analyze.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFileRecordRepository extends JpaRepository<FileRecord,Long> {

    boolean existsByLink(Link link);

    List<FileRecord> findAllByIsDownloadFalse();
}
