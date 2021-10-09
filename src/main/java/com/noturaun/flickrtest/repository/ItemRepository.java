package com.noturaun.flickrtest.repository;


import com.noturaun.flickrtest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
