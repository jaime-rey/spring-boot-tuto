package dev.danvega.contentcalendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.danvega.contentcalendar.model.Content;
import dev.danvega.contentcalendar.model.Status;
import dev.danvega.contentcalendar.model.Type;
import dev.danvega.contentcalendar.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello \uD83D\uDC4D");
        try(InputStream inputStream = TypeReference
                .class.getResourceAsStream("/data/content.json")) {
            repository
                    .saveAll(objectMapper
                            .readValue(inputStream, new TypeReference<List<Content>>() {
            }));
        }
    }

    @Bean
    CommandLineRunner commandLineRunner(ContentRepository repository){
        return args -> {
            //insert some data into DB
            Content content = new Content(null,
                    "Hello GPT",
                    "All about chat gpt",
                    Status.IDEA,
                    Type.COURSE,
                    LocalDateTime.now(),
                    null,
                    ""
            );
            repository.save(content);
        };
    }
}
