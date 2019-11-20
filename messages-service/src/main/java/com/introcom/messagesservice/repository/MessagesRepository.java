package com.introcom.messagesservice.repository;

import com.introcom.messagesservice.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessagesRepository extends MongoRepository<Message, String> {

    Message findTopByPhoneIdOrderByUtcTimeDesc(String phoneId);

}
