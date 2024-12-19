package org.eduardomaravill.data_analyze.repository;

import org.eduardomaravill.data_analyze.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILinkRepository extends JpaRepository<Link,Long> {

    @Query("SELECT CASE WHEN COUNT(1) > 0 THEN true else false END FROM Link l WHERE LOWER(l.downloadUrl) = LOWER(:downloadUrl)")
    boolean existsByDownloadUrl(@Param("downloadUrl") String downloadUrl);

    boolean existsByTitleAndDateCreated(String title,String dateCreated);

}
