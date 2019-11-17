package com.introcom.poiservice.controller;


import com.introcom.poiservice.model.POI;
import com.introcom.poiservice.service.POIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poi")
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

    @PostMapping("")
    public ResponseEntity<POI> addPOI(@RequestBody POI poi){
        return ResponseEntity.ok(poiService.addPOI(poi));
    }

    @GetMapping("")
    public ResponseEntity<List<POI>> getAllPOIs(){
        return ResponseEntity.ok(poiService.getAllPOIs());
    }

    @GetMapping("/{poiId}")
    public ResponseEntity<POI> getPOI(@PathVariable Long poiId){
        return poiService.getPOIById(poiId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{poiId}")
    public ResponseEntity<POI> deletePOI(@PathVariable Long poiId){
        if (poiService.getPOIById(poiId).isPresent()){
            poiService.deletePOI(poiId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("")
    public ResponseEntity<POI> modifyPOI(@RequestBody POI poi){
        return poiService.modifyPOI(poi).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
