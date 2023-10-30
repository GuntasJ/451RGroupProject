package com.tags.cs451r_groupproject_backend.position.rest;

import com.tags.cs451r_groupproject_backend.position.dto.PositionDTO;
import com.tags.cs451r_groupproject_backend.position.model.Position;
import com.tags.cs451r_groupproject_backend.position.model.PositionId;
import com.tags.cs451r_groupproject_backend.position.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@AllArgsConstructor

public class PositionController {
    private final PositionService positionService;
    @GetMapping("/positions")
    public ResponseEntity<List<PositionDTO>> retrieveAllPositions() {
        List<PositionDTO> positionDTOList = positionService.findAll()
                .stream()
                .map(PositionDTO::new)
                .toList();
        return new ResponseEntity<>(positionDTOList, HttpStatus.OK);
    }

    @GetMapping("/positions/{class}/{type}")
    public ResponseEntity<PositionDTO> retrievePosition(@PathVariable("class") String positionClass,
                                                        @PathVariable("type") String positionType) {
        PositionId id = new PositionId(positionClass, positionType);
        PositionDTO positionDTO = new PositionDTO(positionService.findById(id));
        return new ResponseEntity<>(positionDTO, HttpStatus.OK);
    }

    @PostMapping("/positions")
    public ResponseEntity<PositionDTO> createPosition(@RequestBody Position position) {
        PositionDTO positionDTO = new PositionDTO(positionService.createPosition(position));
        return new ResponseEntity<>(positionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/positions/{class}/{type}")
    public ResponseEntity<PositionDTO> updatePosition(@RequestBody Position position,
                                                      @PathVariable("class") String positionClass,
                                                      @PathVariable("type") String positionType) {
        PositionId id = new PositionId(positionClass, positionType);
        PositionDTO positionDTO = new PositionDTO(positionService.updatePosition(position, id));
        return new ResponseEntity<>(positionDTO, HttpStatus.OK);
    }

    @DeleteMapping("/positions/{class}/{type}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePosition(@PathVariable("class") String positionClass,
                               @PathVariable("type") String positionType) {
        PositionId id = new PositionId(positionClass, positionType);
        positionService.deletePosition(id);
    }
}
