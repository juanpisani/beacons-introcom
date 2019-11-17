package com.introcom.beaconservice.controller;

import com.introcom.beaconservice.model.Beacon;
import com.introcom.beaconservice.service.BeaconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beacon")
@CrossOrigin(methods = {
        RequestMethod.POST,
        RequestMethod.GET,
        RequestMethod.OPTIONS,
        RequestMethod.DELETE,
        RequestMethod.PUT
}, origins = "*")
public class BeaconController {

    @Autowired
    BeaconService beaconService;

    @PostMapping("")
    public ResponseEntity<Beacon> addBeacon(@RequestBody Beacon beacon){
        return ResponseEntity.ok(beaconService.addBeacon(beacon));
    }

    @GetMapping("")
    public ResponseEntity<List<Beacon>> getAllBeacons(){
        return ResponseEntity.ok(beaconService.getAllBeacons());
    }

    @GetMapping("/{beaconId}")
    public ResponseEntity<Beacon> getBeacon(@PathVariable Long beaconId){
        return beaconService.getBeaconById(beaconId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{beaconId}")
    public ResponseEntity<Beacon> deleteBeacon(@PathVariable Long beaconId){
        if (beaconService.getBeaconById(beaconId).isPresent()){
            beaconService.deleteBeacon(beaconId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("")
    public ResponseEntity<Beacon> modifyBeacon(@RequestBody Beacon beacon){
        return beaconService.modifyBeacon(beacon).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
