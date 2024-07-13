package com.gabrielvicente.point_of_interest.repository;

import com.gabrielvicente.point_of_interest.entity.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {
}
