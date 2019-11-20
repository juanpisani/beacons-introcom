package com.introcom.beaconservice.repository;

import com.introcom.beaconservice.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MessagesRepository extends MongoRepository<Message, String> {

    Message findTopByPhoneIdOrderByUtcTimeDesc(String phoneId);

}
