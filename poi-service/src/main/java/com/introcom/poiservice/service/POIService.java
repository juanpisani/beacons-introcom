package com.introcom.poiservice.service;

import com.introcom.poiservice.model.POI;
import com.introcom.poiservice.repository.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class POIService {

    @Autowired
    private POIRepository poiRepository;

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
}
