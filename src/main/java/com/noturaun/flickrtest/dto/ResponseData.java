package com.noturaun.flickrtest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseData<T, M> {
    private boolean status;
    private List<String> messages = new ArrayList<>();
    private T payload;
    private T[] payloads;
}
