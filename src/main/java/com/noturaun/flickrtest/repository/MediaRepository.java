package com.noturaun.flickrtest.repository;

import com.noturaun.flickrtest.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
