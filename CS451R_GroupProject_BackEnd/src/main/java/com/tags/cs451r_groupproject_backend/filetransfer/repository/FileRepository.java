package com.tags.cs451r_groupproject_backend.filetransfer.repository;

import com.tags.cs451r_groupproject_backend.filetransfer.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FileRepository extends JpaRepository<File, Long> {

}
