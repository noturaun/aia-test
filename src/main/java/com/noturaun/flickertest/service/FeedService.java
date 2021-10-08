package com.noturaun.flickertest.service;


import com.noturaun.flickertest.entity.Feed;
import com.noturaun.flickertest.entity.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FeedService {
    private final static Logger log = LoggerFactory.getLogger(FeedService.class.getName());

    @Value(value = "${base.url}")
    String baseUrl;
    String format = "format=json&nojsoncallback=1";

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getFeedString(String tags){
        String url = String.format(baseUrl,tags,format);
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        return response;
    }

    public ResponseEntity<Feed> getFeedObj(String tags){
        String url = String.format(baseUrl,tags,format);
        Feed feed = restTemplate.getForObject(url, Feed.class);

        return ResponseEntity.ok(feed);
    }
}
