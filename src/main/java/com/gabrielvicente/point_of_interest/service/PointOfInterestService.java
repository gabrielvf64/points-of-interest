package com.gabrielvicente.point_of_interest.service;

import com.gabrielvicente.point_of_interest.entity.PointOfInterest;
import com.gabrielvicente.point_of_interest.repository.PointOfInterestRepository;
import com.gabrielvicente.point_of_interest.request.CreatePointOfInterestRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Page<PointOfInterest> findAll(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    public List<PointOfInterest> findNearPoints(Long xAxis, Long yAxis, Long maximumDistance) {
        long xAxisMinimum = xAxis - maximumDistance;
        long xAxisMaximum = xAxis + maximumDistance;
        long yAxisMinimum = yAxis - maximumDistance;
        long yAxisMaximum = yAxis + maximumDistance;

        List<PointOfInterest> nearPoints = repository.findNearPoints(xAxisMinimum, xAxisMaximum, yAxisMinimum, yAxisMaximum);

        return nearPoints.stream()
                .filter(poi -> calculateDistance(xAxis, yAxis, poi.getxAxis(), poi.getyAxis()) <= maximumDistance)
                .toList();
    }

    private Double calculateDistance(Long xA, Long yA, Long xB, Long yB) {
        return Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
    }
}
