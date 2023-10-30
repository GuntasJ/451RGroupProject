package com.tags.cs451r_groupproject_backend.administrator.repository;

import com.tags.cs451r_groupproject_backend.administrator.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    @Query("SELECT a FROM Administrator a WHERE a.username = :username")
    Administrator findByUsername(@Param("username") String username);
}
