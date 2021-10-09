package com.noturaun.flickrtest.controller;


import com.noturaun.flickrtest.entity.Feed;
import com.noturaun.flickrtest.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/feeds")
public class FeedController {


    @Autowired
    private FeedService feedService;


    @GetMapping("/string")
    public ResponseEntity<String> getFeedString(@RequestParam(required = false) String tags){
        return feedService.getFeedString(tags);
    }

    @GetMapping
    public ResponseEntity<Feed> getFeed(@RequestParam(required = false) String tags){
        return feedService.getFeed(tags);
    }
}
