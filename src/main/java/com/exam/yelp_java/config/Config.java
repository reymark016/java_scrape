package com.exam.yelp_java.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Config {

    @PostConstruct
    void postConstruct(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mac\\Desktop\\shortcuts\\exam\\chromedriver.exe");
    }

    @Bean
    public ChromeDriver driver(){
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        return new ChromeDriver(chromeOptions);
    }
}
