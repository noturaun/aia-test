package com.noturaun.flickrtest.controller;


import com.noturaun.flickrtest.entity.Feed;
import com.noturaun.flickrtest.entity.Item;
import com.noturaun.flickrtest.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/feeds")
public class FeedController {


    Item[] items;

    @Autowired
    private FeedService feedService;

    @GetMapping("/string")
    public ResponseEntity<String> getFeedString(@RequestParam(required = false) String tags){
        return feedService.getFeedString(tags);
    }

    @GetMapping
    public ResponseEntity<Feed> getFeed(@RequestParam(required = false) String tags){
        items = feedService.getFeed(tags).getBody().getItems();
        return feedService.getFeed(tags);
    }

    @GetMapping("/save")
    public ResponseEntity saveFeed(@RequestParam(required = false) String tags){
        return feedService.saveFeed(items);
    }

    @GetMapping("/saved")
    public Page<Item> getSavedFeed(@RequestParam(required = false) Optional<String> sortBy,
                                   @RequestParam(required = false) Optional<Integer> page,
                                   @RequestParam(required = false) Optional<Integer> pageSize){
                    return feedService.getSavedFeed(sortBy, page, pageSize);
    }

    @DeleteMapping("/save")
    public void deleteFeed(){
        feedService.deleteFeedData();
    }
}
