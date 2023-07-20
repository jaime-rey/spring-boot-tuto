package dev.danvega.contentcalendar.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ContentJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;
}
