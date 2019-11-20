package com.introcom.poiservice.service;

import com.introcom.poiservice.client.BeaconClient;
import com.introcom.poiservice.client.MessageClient;
import com.introcom.poiservice.model.POI;
import com.introcom.poiservice.model.external.Beacon;
import com.introcom.poiservice.model.external.Message;
import com.introcom.poiservice.repository.POIRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class POIService {

    private final POIRepository poiRepository;
    private final MessageClient messageClient;
    private final BeaconClient beaconClient;

    public POIService(POIRepository poiRepository, MessageClient messageClient, BeaconClient beaconClient) {
        this.poiRepository = poiRepository;
        this.messageClient = messageClient;
        this.beaconClient = beaconClient;
    }

    public POI addPOI(POI poi){
        return poiRepository.save(poi);
    }

    public void deletePOI(Long poiId){
        if (poiRepository.findById(poiId).isPresent()) {
            POI poi = poiRepository.findById(poiId).get();
            poiRepository.delete(poi);
        }
    }

    public Optional<POI> getPOIById(Long poiId){
        return poiRepository.findById(poiId);
    }

    public List<POI> getAllPOIs(){
        return (List<POI>) poiRepository.findAll();
    }

    public Optional<POI> modifyPOI(POI poi){
        Optional<POI> optionalPOI = poiRepository.findById(poi.getId());
        if (optionalPOI.isPresent()){
            POI newPOI = optionalPOI.get();
            newPOI.setHtml(poi.getHtml());
            newPOI.setTitle(poi.getTitle());
            return Optional.of(poiRepository.save(newPOI));
        }
        return Optional.empty();
    }

    public Optional<POI> getCurrennt(String phoneId) {
        POI poi = null;
        Message message = messageClient.getLast(phoneId);
        if (message != null){
            Beacon beacon =  beaconClient.getBy(message.getUuid(), message.getMajor(), message.getMinor());
            if (beacon != null){
                 poi= poiRepository.findTopByBeacon(beacon.getId());
            }
        }
        return Optional.ofNullable(poi);
    }
}
