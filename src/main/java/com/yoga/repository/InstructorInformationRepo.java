package com.yoga.repository;

import com.yoga.model.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstructorInformationRepo extends JpaRepository<Instructor, UUID> {
    Instructor findByEmail(String email);
}
