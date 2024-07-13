package com.gabrielvicente.point_of_interest;

import com.gabrielvicente.point_of_interest.entity.PointOfInterest;
import com.gabrielvicente.point_of_interest.repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PointOfInterestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PointOfInterestApplication.class, args);
    }

    @Autowired
    private PointOfInterestRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new PointOfInterest("Coffee Shop", 27L, 12L));
        repository.save(new PointOfInterest("Gas Station", 31L, 18L));
        repository.save(new PointOfInterest("Jewelry", 15L, 12L));
        repository.save(new PointOfInterest("Flower Shop", 19L, 21L));
        repository.save(new PointOfInterest("Pub", 12L, 8L));
        repository.save(new PointOfInterest("Supermarket", 23L, 6L));
        repository.save(new PointOfInterest("Steakhouse", 28L, 2L));
    }
}
