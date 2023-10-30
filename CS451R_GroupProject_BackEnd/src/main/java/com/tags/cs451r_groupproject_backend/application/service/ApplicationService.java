package com.tags.cs451r_groupproject_backend.application.service;

import com.tags.cs451r_groupproject_backend.application.model.Application;
import com.tags.cs451r_groupproject_backend.application.rest.ApplicationNotFoundException;
import com.tags.cs451r_groupproject_backend.application.repository.ApplicationRepository;
import com.tags.cs451r_groupproject_backend.filetransfer.model.File;
import com.tags.cs451r_groupproject_backend.filetransfer.repository.FileRepository;
import com.tags.cs451r_groupproject_backend.filetransfer.rest.FileNotFoundException;
import com.tags.cs451r_groupproject_backend.position.model.PositionId;
import com.tags.cs451r_groupproject_backend.position.respository.PositionRepository;
import com.tags.cs451r_groupproject_backend.student.rest.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    private PositionRepository positionRepository;
    private FileRepository fileRepository;

    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    public Application findById(Long id) {
        Optional<Application> applicationOptional = applicationRepository.findById(id);
        return applicationOptional.orElseThrow(() -> new ApplicationNotFoundException(id));
    }

    public Application createApplication(Application application, Long fileId) {
        //Check if a valid position exists that matches up with the applications desiredClasses.
        //If so, add it to it.
        //Don't add the position if the application doesn't meet the required standing.
        for(String desiredClass : application.getDesiredClasses()) {
            for(String desiredType : application.getDesiredTypes()) {
                PositionId id = new PositionId(desiredClass, desiredType);
                positionRepository.findById(id).ifPresent(application::addPosition);
            }
        }

        if (fileId != null) {
            Optional<File> fileOptional = fileRepository.findById(fileId);
            application.setFile(fileOptional.orElseThrow(() -> new FileNotFoundException(fileId)));
        }

        return applicationRepository.save(application);
    }

    public Application updateApplication(Application newApplication, Long id) {
        return applicationRepository.findById(id).map(application -> {
            application.copyFrom(newApplication);
            return applicationRepository.save(application);
        }).orElseThrow(() -> new ApplicationNotFoundException(id));
    }

    public void deleteApplication(Long id) {
        Optional<Application> applicationOptional = applicationRepository.findById(id);
        if(applicationOptional.isPresent()) {
            applicationRepository.delete(applicationOptional.get());
        }
        else {
            throw new StudentNotFoundException(id);
        }
    }
}
