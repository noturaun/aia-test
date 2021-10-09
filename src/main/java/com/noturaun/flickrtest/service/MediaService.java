package com.noturaun.flickrtest.service;

import com.noturaun.flickrtest.entity.Media;
import com.noturaun.flickrtest.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    public Iterable<Media> findAll(){
        return mediaRepository.findAll();
    }

    public Media save(Media media){
        return mediaRepository.save(media);
    }

    public void deleteMedia(){
        mediaRepository.deleteAll();
    }
}
