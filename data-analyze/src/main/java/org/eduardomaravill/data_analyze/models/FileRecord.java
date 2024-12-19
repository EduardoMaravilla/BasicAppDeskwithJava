package org.eduardomaravill.data_analyze.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "records")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_records", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "link_id", nullable = false)
    private Link link;

    @Column(name = "is_download", nullable = false)
    private boolean isDownload = false;

    @Column(name = "is_analyzed", nullable = false)
    private boolean isAnalyzed = false;

    @Column(name = "path")
    private String path;
}
