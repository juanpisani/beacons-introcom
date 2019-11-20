package com.introcom.poiservice.controller;


import com.introcom.poiservice.model.POI;
import com.introcom.poiservice.service.POIService;
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
public class POIController {

    @Autowired
    POIService poiService;

    /**
     * Generate new poi
     *
     * @param poi poi object to be created
     * @return Response entity with new poi
     */
    @PostMapping("")
    public ResponseEntity<POI> addPOI(@RequestBody POI poi){
        return ResponseEntity.ok(poiService.addPOI(poi));
    }

    /**
     * Retrieve all pois
     *
     * @return Response entity with list of all pois
     */
    @GetMapping("")
    public ResponseEntity<List<POI>> getAllPOIs(){
        return ResponseEntity.ok(poiService.getAllPOIs());
    }

    /**
     * Retrieve a specific poi
     *
     * @param poiId poi pk identifier
     * @return Response entity with poi to be found, 200 if ok, 404 if not found
     */
    @GetMapping("/{poiId}")
    public ResponseEntity<POI> getPOI(@PathVariable Long poiId){
        return poiService.getPOIById(poiId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Delete poi
     *
     * @param poiId poi pk identifier
     * @return Response entity 200 if deleted ok, 404 if not found
     */
    @DeleteMapping("/{poiId}")
    public ResponseEntity<POI> deletePOI(@PathVariable Long poiId){
        if (poiService.getPOIById(poiId).isPresent()){
            poiService.deletePOI(poiId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Update poi
     *
     * @param poi poi object with modified params
     * @return Response entity, code -> 200 if modified ok, 404 if not found in db
     */
    @PutMapping("")
    public ResponseEntity<POI> modifyPOI(@RequestBody POI poi){
        return poiService.modifyPOI(poi).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get phone current poi
     *
     * This endpoint relies on two different requests perpetrated to two other services in the platfomor.
     * Firstly, the messages-service is asked for the last message to be sent by the specified phone
     * Secondly, the beacon-service is asked for the beacon corresponding to that message
     * Finally, this services looks in the database for the poi corresponding to
     *  the beacon and returns it if present.
     *
     * @param phoneId phone pk identifier
     * @return Resoinse entity code 200 if ok 400 otherwise
     */
    @GetMapping("current/{phoneId}")
    public ResponseEntity getCurrentPOI(@PathVariable String phoneId){
        return poiService.getCurrennt(phoneId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}
