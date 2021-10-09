package com.noturaun.flickrtest.service;


import com.noturaun.flickrtest.dto.ResponseData;
import com.noturaun.flickrtest.entity.Feed;
import com.noturaun.flickrtest.entity.Item;
import com.noturaun.flickrtest.entity.Media;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;


@Service
public class FeedService {
    private final static Logger log = LoggerFactory.getLogger(FeedService.class.getName());

    @Value(value = "${base.url}")
    String baseUrl;
    @Value(value = "${format}")
    String format;
    @Value(value = "${nojsoncallback}")
    String nojsoncallback;

    Item[] temp;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ItemService itemService;

    @Autowired
    private MediaService mediaService;

    public ResponseEntity<String> getFeedString(String tags){
        String url = String.format(baseUrl,tags,format,nojsoncallback);
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        //log.info(response.toString());

        return response;
    }

    public ResponseEntity<Feed> getFeed(String tags){
        String url = String.format(baseUrl,tags,format,nojsoncallback);
        Feed feed = restTemplate.getForObject(url, Feed.class);
        //log.info(feed.toString());
        temp = feed.getItems();
        return ResponseEntity.ok(feed);
    }


    public Page<Item> getSavedFeed(Optional<String> sortBy, Optional<Integer> pageSize, Optional<Integer> page){
        return itemService.getSavedItem(sortBy,page, pageSize);
    }

    public ResponseEntity<ResponseData<Item, Media>> saveFeed(Item[] items){
        ResponseData<Item, Media> responseData = new ResponseData<>();
        ResponseEntity res;
            for (var item : items) {
                itemService.save(item);
            }
            responseData.getMessages().add("Feed successfully saved to database");
            responseData.setStatus(true);
            responseData.setPayloads(items);
            res = ResponseEntity.status(HttpStatus.OK).body(responseData);
            return res;

    }


    public void deleteFeedData(){
        itemService.deleteItem();
    }
}
