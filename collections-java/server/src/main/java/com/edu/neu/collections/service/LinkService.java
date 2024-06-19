package com.edu.neu.collections.service;

import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private int count;

    public int increamentCount() {
        return count++;
    }
}
