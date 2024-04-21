package com.yoga.repository;

import com.yoga.model.entity.YogaClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface YogaClassInformationRepo extends JpaRepository<YogaClasses, UUID> {
}
