package com.tags.cs451r_groupproject_backend.position.dto;

import com.tags.cs451r_groupproject_backend.application.dto.ApplicationDTO;
import com.tags.cs451r_groupproject_backend.application.model.Application;
import com.tags.cs451r_groupproject_backend.general.Copier;
import com.tags.cs451r_groupproject_backend.position.model.Position;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PositionDTO implements Copier<Position> {
    private String positionClass;
    private String requiredStanding;
    private List<String> semester;
    private String positionType;
    private String notes;

    private List<ApplicationDTO> applicants = new ArrayList<>();


    public PositionDTO(Position position) {
        copyFrom(position);

        for(Application application : position.getApplicants()) {
            ApplicationDTO applicationDTO = new ApplicationDTO();
            applicationDTO.copyFrom(application);
            applicants.add(applicationDTO);
        }
    }

    @Override
    public void copyFrom(Position entity) {
        this.positionClass = entity.getPositionClass();
        this.requiredStanding = entity.getRequiredStanding();
        this.semester = entity.getSemester();
        this.positionType = entity.getPositionType();
        this.notes = entity.getNotes();
    }
}
