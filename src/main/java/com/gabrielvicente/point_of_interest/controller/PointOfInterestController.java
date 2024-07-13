package com.gabrielvicente.point_of_interest.controller;

import com.gabrielvicente.point_of_interest.request.CreatePointOfInterestRequest;
import com.gabrielvicente.point_of_interest.service.PointOfInterestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointOfInterestController {

    private final PointOfInterestService pointOfInterestService;

    public PointOfInterestController(PointOfInterestService pointOfInterestService) {
        this.pointOfInterestService = pointOfInterestService;
    }

    @PostMapping("/points-of-interests")
    public ResponseEntity<Object> createPointOfInterest(@RequestBody CreatePointOfInterestRequest request) {

        pointOfInterestService.createPointOfInterest(request);
        return ResponseEntity.ok().build();
    }
}
