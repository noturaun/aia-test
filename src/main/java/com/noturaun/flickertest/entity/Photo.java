package com.noturaun.flickertest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    String title;
    String link;
    Media media;
    String date_taken;
    String description;
    String published;
    String author;
    String author_id;
    String tags;
}
