package com.noturaun.flickrtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

//import javax.persistence.*;


@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String link;
    @OneToOne
    @JoinColumn(name = "media_id")
    Media media;
    String date_taken;
    @Column(columnDefinition = "TEXT")
    String description;
    String published;
    String author;
    String author_id;
    @Column(columnDefinition = "TEXT")
    String tags;
}
