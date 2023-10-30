package com.tags.cs451r_groupproject_backend.application.repository;

import com.tags.cs451r_groupproject_backend.application.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
