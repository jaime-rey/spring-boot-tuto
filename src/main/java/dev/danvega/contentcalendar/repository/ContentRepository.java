package dev.danvega.contentcalendar.repository;

import dev.danvega.contentcalendar.model.Content;
import dev.danvega.contentcalendar.model.Status;
import dev.danvega.contentcalendar.model.Type;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByTitleContains(String keyword);

    @Query("""
        SELECT * FROM Content
        where status = :status
    """)
    List<Content> listByStatus(@Param("status") Status status);
    @Query("""
        SELECT * FROM Content
        where content_type = :type
    """)
    List<Content> listByType(@Param("type") Type type);
}
