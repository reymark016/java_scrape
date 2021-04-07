package com.exam.yelp_java.controller;

import com.exam.yelp_java.service.ScrapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ScrapeController {
    @Autowired
    ScrapeService scrapeService;

    @GetMapping("/scrape")
    public String greeting() {
        return scrapeService.scrape();
    }
}
