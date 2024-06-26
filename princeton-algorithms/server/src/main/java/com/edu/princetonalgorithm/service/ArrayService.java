package com.edu.princetonalgorithm.service;

import org.springframework.stereotype.Service;

@Service
public class ArrayService {

    private int count;

    public int increamentCount() {
        return count++;
    }
}
