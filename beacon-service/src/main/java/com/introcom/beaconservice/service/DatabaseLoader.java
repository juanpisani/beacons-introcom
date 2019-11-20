package com.introcom.beaconservice.service;


import com.introcom.beaconservice.model.Beacon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DatabaseLoader {

    @Autowired
    BeaconService beaconService;

    /**
     * Loads database with 2 Beacons
     */
    @PostConstruct
    public void addBeacons(){
        try {
            beaconService.addBeacon(new Beacon("f57d5029-a509-4bc7-a5c0-444f8eb88eee", 1000, 420));

        }catch (Exception ignored){

        }
        try {
            beaconService.addBeacon(new Beacon("2f234454-cf6d-4a0f-adf2-f4911ba9ffa6", 99, 98));
        }catch (Exception ignored){

        }
    }
}
