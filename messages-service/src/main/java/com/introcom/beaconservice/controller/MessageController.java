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


    /**
     * Creates new Message in db
     *
     * @param uuid beacon identifier corresponding to message
     * @param major beacon identifier corresponding to message
     * @param minor beacon identifier corresponding to message
     * @param phoneId phone pk corresponding to message
     * @return Response entity, code 200 if ok, 400 if bad request
     */
    @GetMapping("/{uuid}/{major}/{minor}/{phoneId}")
    public ResponseEntity<Message> newMessage(@PathVariable String uuid, @PathVariable String major, @PathVariable String minor, @PathVariable String phoneId){
           return messageService.newMessage(uuid, major, minor, phoneId).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    /**
     * Retrieve all messages stored
     *
     * @return List of all Messages
     */
    @GetMapping("")
    public List<Message> getAll(){
        return messageService.getAll();
    }

    /**
     * Get last beacon recognized by a specific phone
     *
     * @param phoneId phone identifier
     * @return Message from las beacon that was read by the phone
     */
    @GetMapping("last/{phoneId}")
    public Message getLastBeaconForPhone(@PathVariable String phoneId){
        return messageService.getLast(phoneId);
    }
}
