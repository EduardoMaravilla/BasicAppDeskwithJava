package org.eduardomaravill.data_analyze.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "links")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_links", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "download_url", nullable = false)
    private String downloadUrl;

    @Column(name = "date_created", nullable = false)
    private String dateCreated;
}
