package com.noturaun.flickertest.entity;


import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feed implements Serializable {
    String title;
    String link;
    String description;
    String modified;
    String generator;
    Photo[] items;
}
