package com.tags.cs451r_groupproject_backend.administrator.rest;

import com.tags.cs451r_groupproject_backend.administrator.model.Administrator;
import com.tags.cs451r_groupproject_backend.administrator.dto.AdministratorDTO;
import com.tags.cs451r_groupproject_backend.administrator.service.AdministratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin
@RestController
public class AdministratorController {

    private AdministratorService administratorService;

    @GetMapping("/administrators")
    public ResponseEntity<List<AdministratorDTO>> retrieveAllAdministrators() {
        List<AdministratorDTO> administratorDTOList = administratorService.findAll()
                .stream()
                .map(AdministratorDTO::new)
                .toList();

        return new ResponseEntity<>(administratorDTOList, HttpStatus.OK);
    }

    @GetMapping("/administrators/{id}")
    public ResponseEntity<AdministratorDTO> retrieveAdministrator(@PathVariable Long id) {
        AdministratorDTO administratorDTO = new AdministratorDTO(administratorService.findById(id));
        return new ResponseEntity<>(administratorDTO, HttpStatus.OK);
    }

    @PostMapping("/administrators")
    public ResponseEntity<AdministratorDTO> createAdministrator(@RequestBody Administrator administrator) {
        AdministratorDTO administratorDTO = new AdministratorDTO(administratorService.createAdministrator(administrator));
        return new ResponseEntity<>(administratorDTO, HttpStatus.CREATED);
    }

    @PutMapping("/administrators/{id}")
    public ResponseEntity<AdministratorDTO> updateAdministrator(@RequestBody Administrator administrator, @PathVariable Long id) {
        AdministratorDTO administratorDTO = new AdministratorDTO(administratorService.updateAdministrator(administrator, id));
        return new ResponseEntity<>(administratorDTO, HttpStatus.OK);
    }

    @DeleteMapping("/administrators/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdministrator(@PathVariable Long id) {
        administratorService.deleteAdministrator(id);
    }

}
