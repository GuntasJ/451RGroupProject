package com.tags.cs451r_groupproject_backend.application.rest;

import com.tags.cs451r_groupproject_backend.application.dto.ApplicationDTO;
import com.tags.cs451r_groupproject_backend.application.model.Application;
import com.tags.cs451r_groupproject_backend.application.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class ApplicationController {

    private ApplicationService applicationService;

    @GetMapping("/applications")
    public ResponseEntity<List<ApplicationDTO>> retrieveAllApplications() {
        List<ApplicationDTO> applicationDTOList = applicationService.findAll()
                .stream()
                .map(ApplicationDTO::new)
                .toList();
        return new ResponseEntity<>(applicationDTOList, HttpStatus.OK);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<ApplicationDTO> retrieveApplication(@PathVariable Long id) {
        ApplicationDTO applicationDTO = new ApplicationDTO(applicationService.findById(id));
        return new ResponseEntity<>(applicationDTO, HttpStatus.OK);
    }

    @PostMapping("/applications")
    public ResponseEntity<ApplicationDTO> createApplication(@RequestBody Application application,
                                                            @RequestParam(name = "file_id", required = false) Long fileId) {
        ApplicationDTO applicationDTO = new ApplicationDTO(applicationService.createApplication(application, fileId));
        return new ResponseEntity<>(applicationDTO, HttpStatus.CREATED);
    }


    @PutMapping("/applications/{id}")
    public ResponseEntity<ApplicationDTO> updateApplication(@RequestBody Application newApplication, @PathVariable Long id) {
        ApplicationDTO applicationDTO = new ApplicationDTO(applicationService.updateApplication(newApplication, id));
        return new ResponseEntity<>(applicationDTO, HttpStatus.OK);
    }

    @DeleteMapping("/applications/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
    }

}
