package com.yoga.repository;

import com.yoga.model.entity.UsersInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserInformationRepository extends JpaRepository<UsersInformation, UUID> {

    UsersInformation findByEmail(String email);

}
