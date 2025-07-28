package com.practise.cabbookdriver.cab_book_driver.service;

import com.practise.cabbookdriver.cab_book_driver.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabDriverService {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public boolean updateLocation(Object message) {
        kafkaTemplate.send(AppConstant.CAB_LOCATION, message);
        return true;
    }
}
