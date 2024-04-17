package com.yoga.repository;

import com.yoga.model.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudioInformationRepo extends JpaRepository<Studio, UUID> {

}
