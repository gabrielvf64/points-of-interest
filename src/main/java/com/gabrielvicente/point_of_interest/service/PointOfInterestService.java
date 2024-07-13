package com.gabrielvicente.point_of_interest.service;

import com.gabrielvicente.point_of_interest.entity.PointOfInterest;
import com.gabrielvicente.point_of_interest.repository.PointOfInterestRepository;
import com.gabrielvicente.point_of_interest.request.CreatePointOfInterestRequest;
import org.springframework.stereotype.Service;

@Service
public class PointOfInterestService {

    private final PointOfInterestRepository repository;

    public PointOfInterestService(PointOfInterestRepository repository) {
        this.repository = repository;
    }

    public void createPointOfInterest(CreatePointOfInterestRequest request) {
        PointOfInterest entity = request.toEntity();
        repository.save(entity);
    }
}
