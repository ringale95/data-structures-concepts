package com.edu.princetonalgorithm.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.princetonalgorithm.service.*;

@RestController
public class ArrayController {

    @Autowired
    private ArrayService arrayService;

    @GetMapping("/get-count")
    public int add() {
        return arrayService.increamentCount();
    }
}