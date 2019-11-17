package com.introcom.poiservice.repository;

import com.introcom.poiservice.model.POI;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POIRepository extends CrudRepository<POI, Long> {
}
