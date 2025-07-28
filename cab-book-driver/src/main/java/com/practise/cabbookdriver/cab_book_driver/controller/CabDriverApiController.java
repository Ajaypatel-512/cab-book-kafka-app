package com.practise.cabbookdriver.cab_book_driver.controller;

import com.practise.cabbookdriver.cab_book_driver.service.CabDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cab-driver")
public class CabDriverApiController {
    @Autowired
    private CabDriverService cabDriverService;

    // Example endpoint to send a message to the Kafka topic
    @PutMapping("/location")
    public ResponseEntity updateLocation(String location) throws InterruptedException {
        int range = 100;
        while (range > 0) {
            cabDriverService.updateLocation(Math.random() + " , " + Math.random());
            Thread.sleep(1000);
            range --;
        }

        return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);
    }
}
