package com.noturaun.flickertest.controller;


import com.noturaun.flickertest.entity.Feed;
import com.noturaun.flickertest.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:5000")
@RequestMapping("/feeds")
public class FeedController {


    @Autowired
    private FeedService feedService;


    @GetMapping("/string")
    public ResponseEntity<String> getFeedString(@RequestParam(required = false) String tags){
        return feedService.getFeedString(tags);
    }

    @GetMapping
    public ResponseEntity<Feed> getFeedObj(@RequestParam(required = false) String tags){
        return feedService.getFeedObj(tags);
    }
}
