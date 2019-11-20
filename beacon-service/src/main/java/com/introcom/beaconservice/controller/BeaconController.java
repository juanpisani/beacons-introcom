package com.introcom.beaconservice.controller;

import com.introcom.beaconservice.model.Beacon;
import com.introcom.beaconservice.service.BeaconService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BeaconController {

    @Autowired
    BeaconService beaconService;

    /**
     * Creates beacon and adds it to database
     *
     * @param beacon Beacon object to be created
     * @return Response entity with new beacon
     */
    @PostMapping("")
    public ResponseEntity<Beacon> addBeacon(@RequestBody Beacon beacon){
        return ResponseEntity.ok(beaconService.addBeacon(beacon));
    }

    /**
     * Get all beacons stores in database
     *
     * @return Response entity with list of all beacons
     */
    @GetMapping("")
    public ResponseEntity<List<Beacon>> getAllBeacons(){
        return ResponseEntity.ok(beaconService.getAllBeacons());
    }

    /**
     * Get a specific beacon
     *
     * @param beaconId Primary key id of the beacon you want to retrieve
     * @return Response entity with status code 200 if the beacon was found, 404 otherwise
     */
    @GetMapping("/{beaconId}")
    public ResponseEntity<Beacon> getBeacon(@PathVariable Long beaconId){
        return beaconService.getBeaconById(beaconId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get Beacon by its specific parameters: uuid, major, minor
     *
     * @param uuid Beacon identifier
     * @param major Beacon identifier
     * @param minor Beacon identifier
     * @return Beacon object
     */
    @GetMapping("{uuid}/{major}/{minor}")
    public Beacon getByThings(@PathVariable String uuid, @PathVariable Integer major, @PathVariable Integer minor){
        return beaconService.getBy(uuid, major, minor);
    }

    /**
     * Delete a specific beacon
     *
     * @param beaconId Beacon pk identifier
     * @return Response entity 200 if beacon was deleted, 404 if it could not find it in db
     */
    @DeleteMapping("/{beaconId}")
    public ResponseEntity<Beacon> deleteBeacon(@PathVariable Long beaconId){
        if (beaconService.getBeaconById(beaconId).isPresent()){
            beaconService.deleteBeacon(beaconId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Update Beacon parameters
     *
     * @param beacon beacon to be updated with its new params
     * @return Response entity with updated beacon, status code 200 if ok, 404 if it could not find it
     */
    @PutMapping("")
    public ResponseEntity<Beacon> modifyBeacon(@RequestBody Beacon beacon){
        return beaconService.modifyBeacon(beacon).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
