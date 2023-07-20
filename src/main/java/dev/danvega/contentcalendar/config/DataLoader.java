package dev.danvega.contentcalendar.config;

import dev.danvega.contentcalendar.model.Content;
import dev.danvega.contentcalendar.model.Status;
import dev.danvega.contentcalendar.model.Type;
import dev.danvega.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
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
