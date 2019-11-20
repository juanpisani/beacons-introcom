package com.introcom.beaconservice.service;

import com.introcom.beaconservice.model.Beacon;
import com.introcom.beaconservice.repository.BeaconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeaconService {

    @Autowired
    BeaconRepository beaconRepository;

    public Beacon addBeacon(Beacon beacon){
        if (beaconRepository.existsByUUIDAndMajorAndMinor(beacon.getUUID(), beacon.getMajor(), beacon.getMinor())){
            throw new RuntimeException("El beacon ya existe");
        }
        return beaconRepository.save(beacon);
    }

    public void deleteBeacon(Long beaconId){
        if (beaconRepository.findById(beaconId).isPresent()) {
            Beacon beacon = beaconRepository.findById(beaconId).get();
            beaconRepository.delete(beacon);
        }
    }

    public Optional<Beacon> getBeaconById(Long beaconId){
        return beaconRepository.findById(beaconId);
    }

    public List<Beacon> getAllBeacons(){
        return (List<Beacon>) beaconRepository.findAll();
    }

    public Optional<Beacon> modifyBeacon(Beacon beacon){
        Optional<Beacon> optionalBeacon = beaconRepository.findById(beacon.getId());
        if (optionalBeacon.isPresent()){
            Beacon newBeacon = optionalBeacon.get();
            newBeacon.setMajor(beacon.getMajor());
            newBeacon.setMinor(beacon.getMinor());
            return Optional.of(beaconRepository.save(newBeacon));
        }
        return Optional.empty();
    }

    public Beacon getBy(String uuid, Integer major, Integer minor) {
        return beaconRepository.findByUUIDAndMinorAndMajor(uuid, major,minor);
    }
}
