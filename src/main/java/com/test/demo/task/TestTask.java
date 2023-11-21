package com.test.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestTask{

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "0 0/15 * * * ? ")
    public void start(){

    }
}
