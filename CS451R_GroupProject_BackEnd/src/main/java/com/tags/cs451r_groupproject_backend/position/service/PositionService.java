package com.tags.cs451r_groupproject_backend.position.service;

import com.tags.cs451r_groupproject_backend.application.model.Application;
import com.tags.cs451r_groupproject_backend.application.repository.ApplicationRepository;
import com.tags.cs451r_groupproject_backend.position.model.Position;
import com.tags.cs451r_groupproject_backend.position.model.PositionId;
import com.tags.cs451r_groupproject_backend.position.respository.PositionRepository;
import com.tags.cs451r_groupproject_backend.position.rest.PositionNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PositionService {
    private PositionRepository positionRepository;
    private ApplicationRepository applicationRepository;

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public Position findById(PositionId id) {
        Optional<Position> positionOptional = positionRepository.findById(id);
        return positionOptional.orElseThrow(() -> new PositionNotFoundException(id));
    }

    private boolean isApplicationEligibleForPosition(Application application, Position position) {
        return application.getDesiredClasses().contains(position.getPositionClass()) &&
                application.getStanding().equals(position.getRequiredStanding());
    }
    public Position createPosition(Position position) {
        //When saving a position, check if there are applicants that have desiredClasses that match up with that position
        //If so, add them to the position
        //Don't add them if they do not meet the required standing
        applicationRepository.findAll()
                .stream()
                .filter(application -> isApplicationEligibleForPosition(application, position))
                .forEach(position::addApplication);

        return positionRepository.save(position);
    }

    public Position updatePosition(Position newPosition, PositionId id) {
        return positionRepository.findById(id).map(position -> {
            position.copyFrom(newPosition);
            return positionRepository.save(position);
        }).orElseThrow(
                () -> new PositionNotFoundException(id)
        );
    }

    public void deletePosition(PositionId id) {
        Optional<Position> positionOptional = positionRepository.findById(id);
        if(positionOptional.isPresent()) {
            positionRepository.delete(positionOptional.get());
        }
        else {
            throw new PositionNotFoundException(id);
        }
    }
}
