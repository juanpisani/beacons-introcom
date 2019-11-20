package com.introcom.poiservice.client;


import com.introcom.poiservice.model.external.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "message-service")
public interface MessageClient {

    @GetMapping("/last/{phoneId}")
    Message getLast(@PathVariable String phoneId);

}
