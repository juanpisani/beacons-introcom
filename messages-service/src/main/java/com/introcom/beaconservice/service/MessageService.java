package com.introcom.beaconservice.service;

import com.introcom.beaconservice.model.Message;
import com.introcom.beaconservice.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessagesRepository messagesRepository;

    public MessageService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public Optional<Message> newMessage(String uuid, String major, String minor, String phoneId) {
       return Optional.ofNullable(messagesRepository.save(
                new Message(
                        System.currentTimeMillis(),
                        phoneId,
                        uuid,
                        Integer.valueOf(minor),
                        Integer.valueOf(major)
                )
        ));

    }

    public List<Message> getAll() {
        return messagesRepository.findAll();
    }

    public Message getLast(String phoneId) {
        return messagesRepository.findTopByPhoneIdOrderByUtcTimeDesc(phoneId);
    }
}
