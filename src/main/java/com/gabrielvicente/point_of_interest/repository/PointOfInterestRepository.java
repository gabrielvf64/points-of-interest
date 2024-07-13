package com.gabrielvicente.point_of_interest.repository;

import com.gabrielvicente.point_of_interest.entity.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {

    @Query("""
            SELECT p FROM PointOfInterest p
            WHERE (p.xAxis >= :xAxisMinimum AND p.xAxis <= :xAxisMaximum AND p.yAxis >= :yAxisMinimum AND p.yAxis <= :yAxisMaximum)
            """)
    List<PointOfInterest> findNearPoints(@Param("xAxisMinimum") long xAxisMinimum,
                                         @Param("xAxisMaximum") long xAxisMaximum,
                                         @Param("yAxisMinimum") long yAxisMinimum,
                                         @Param("yAxisMaximum") long yAxisMaximum);
}
