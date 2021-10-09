package com.noturaun.flickrtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class Item {
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
