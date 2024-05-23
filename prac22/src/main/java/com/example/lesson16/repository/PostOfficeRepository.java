package com.example.lesson16.repository;

import com.example.lesson16.model.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, UUID> {
    List<PostOffice> getAllById(UUID id);

    List<PostOffice> findPostOfficesByName(String name);
}