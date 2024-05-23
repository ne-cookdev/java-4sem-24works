package com.example.lesson16.repository;

import com.example.lesson16.model.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DepartureRepository extends JpaRepository<Departure, UUID> {
    List<Departure> findAllById(UUID id);

    List<Departure> findAllByType(String type);

    List<Departure> findAllByDepartureDate(int departureDate);
}