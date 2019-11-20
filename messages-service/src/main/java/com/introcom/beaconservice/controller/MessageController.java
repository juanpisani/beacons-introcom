package com.introcom.beaconservice.controller;

import com.introcom.beaconservice.model.Message;
import com.introcom.beaconservice.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(methods = {
        RequestMethod.POST,
        RequestMethod.GET,
        RequestMethod.OPTIONS,
        RequestMethod.DELETE,
        RequestMethod.PUT
}, origins = "*")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/{uuid}/{major}/{minor}/{phoneId}")
    public ResponseEntity<Message> newMessage(@PathVariable String uuid, @PathVariable String major, @PathVariable String minor, @PathVariable String phoneId){
           return messageService.newMessage(uuid, major, minor, phoneId).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("")
    public List<Message> getAll(){
        return messageService.getAll();
    }


    @GetMapping("last/{phoneId}")
    public Message getLastBeaconForPhone(@PathVariable String phoneId){
        return messageService.getLast(phoneId);
    }
}
