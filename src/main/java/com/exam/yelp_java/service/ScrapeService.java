package com.exam.yelp_java.service;


import lombok.AllArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScrapeService {
    private static final String URL = "https://www.yelp.com/biz/spiral-pasay-2";

    private  final ChromeDriver driver;
    private ArrayList<String> revs;
    private ArrayList<String> avs;

    public String scrape(){
        driver.get(URL);
        final List<WebElement> reviewersList = driver.findElementsByXPath("//a[contains(@href, '/user')]");
        final List<WebElement> avatarsList = driver.findElementsByXPath("//a[contains(@href, '/user')]//img[contains(@class, 'photo-box-img__373c0__35y5v')]");


        for (WebElement reviewer: reviewersList){
            if(reviewer.getText().isEmpty()){
                continue;
            } else {
                revs.add(reviewer.getText());
            }
        }

        for (WebElement avatar: avatarsList){
            avs.add(avatar.getAttribute("src"));
        }

        System.out.println("map end");
        System.out.println(revs);
        System.out.println(avs);
        driver.quit();
        return "reviewers: " + revs + "avatars: " + avs;
    }
}
