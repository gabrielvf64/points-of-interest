package com.gabrielvicente.point_of_interest.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "point_of_interest")
public class PointOfInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long xAxis;

    private Long yAxis;

    public PointOfInterest() {
    }

    public PointOfInterest(String name, Long xAxis, Long yAxis) {
        this.name = name;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getxAxis() {
        return xAxis;
    }

    public void setxAxis(Long xAxis) {
        this.xAxis = xAxis;
    }

    public Long getyAxis() {
        return yAxis;
    }

    public void setyAxis(Long yAxis) {
        this.yAxis = yAxis;
    }
}
