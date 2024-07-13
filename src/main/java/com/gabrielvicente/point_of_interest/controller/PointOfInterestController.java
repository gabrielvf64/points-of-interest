package com.gabrielvicente.point_of_interest.controller;

import com.gabrielvicente.point_of_interest.entity.PointOfInterest;
import com.gabrielvicente.point_of_interest.request.CreatePointOfInterestRequest;
import com.gabrielvicente.point_of_interest.service.PointOfInterestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/points-of-interests")
    public ResponseEntity<Page<PointOfInterest>> listPointOfInterest(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<PointOfInterest> paginatedPointsOfInterest = pointOfInterestService.findAll(PageRequest.of(page, pageSize));
        return ResponseEntity.ok(paginatedPointsOfInterest);
    }
}
