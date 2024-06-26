package com.edu.neu.collections.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.neu.collections.service.LinkService;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/get-count")
    public int add() {
        return linkService.increamentCount();
    }
}