package com.gabrielvicente.point_of_interest.request;

import com.gabrielvicente.point_of_interest.entity.PointOfInterest;

public record CreatePointOfInterestRequest(String name,
                                           Long xAxis,
                                           Long yAxis) {

    public PointOfInterest toEntity() {
        return new PointOfInterest(name, xAxis, yAxis);
    }
}
