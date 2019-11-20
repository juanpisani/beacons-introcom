package com.introcom.beaconservice.repository;

import com.introcom.beaconservice.model.Beacon;
import org.springframework.data.repository.CrudRepository;

public interface BeaconRepository extends CrudRepository<Beacon, Long> {

    boolean existsByUUIDAndMajorAndMinor(String uuid, int major, int minor);

    Beacon findByUUIDAndMinorAndMajor(String uuid, int major, int minor);
}
