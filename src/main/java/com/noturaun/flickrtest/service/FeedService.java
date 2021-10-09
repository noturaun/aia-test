package com.noturaun.flickrtest.service;


import com.noturaun.flickrtest.entity.Feed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FeedService {
    private final static Logger log = LoggerFactory.getLogger(FeedService.class.getName());

    @Value(value = "${base.url}")
    String baseUrl;
    @Value(value = "${format}")
    String format;
    @Value(value = "${nojsoncallback}")
    String nojsoncallback;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getFeedString(String tags){
        String url = String.format(baseUrl,tags,format,nojsoncallback);
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        log.info(response.toString());

        return response;
    }

    public ResponseEntity<Feed> getFeed(String tags){
        String url = String.format(baseUrl,tags,format,nojsoncallback);
        Feed feed = restTemplate.getForObject(url, Feed.class);
        log.info(feed.toString());

        return ResponseEntity.ok(feed);
    }
}
