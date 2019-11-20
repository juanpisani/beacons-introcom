package com.introcom.poiservice.client;


import com.introcom.poiservice.model.external.Beacon;
import com.introcom.poiservice.model.external.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "beacon-service")
public interface BeaconClient {

    @GetMapping("{uuid}/{major}/{minor}")
    Beacon getBy(@PathVariable String uuid, @PathVariable Integer major, @PathVariable Integer minor);

}
