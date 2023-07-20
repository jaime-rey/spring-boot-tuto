package dev.danvega.contentcalendar.controller;

import dev.danvega.contentcalendar.config.ContentCalendarProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final ContentCalendarProperties properties;

    @GetMapping("/")
    public ContentCalendarProperties home(){
        return properties;
    }

}
