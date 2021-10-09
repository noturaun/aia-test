package com.noturaun.flickrtest.service;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.noturaun.flickrtest.entity.Item;
import com.noturaun.flickrtest.entity.Media;
import com.noturaun.flickrtest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MediaService mediaService;

    public Iterable<Item> findAll(){
        return itemRepository.findAll();
    }

    public Item save(Item item){
        mediaService.save(item.getMedia());
        return itemRepository.save(item);
    }

    public Page<Item> getSavedItem(Optional<String> sortBy, Optional<Integer> pageSize, Optional<Integer> page){
        return itemRepository.findAll(
                PageRequest.of(
                        page.orElse(0),pageSize.orElse(5),
                        Sort.Direction.ASC,
                        sortBy.orElse("id"))
        );
    }

    public void deleteItem(){
        itemRepository.deleteAll();
        mediaService.deleteMedia();
    }
}
