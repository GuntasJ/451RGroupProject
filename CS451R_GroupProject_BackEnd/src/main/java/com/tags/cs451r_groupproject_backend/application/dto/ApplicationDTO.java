package com.tags.cs451r_groupproject_backend.application.dto;

import com.tags.cs451r_groupproject_backend.application.model.Application;
import com.tags.cs451r_groupproject_backend.application.model.ApplicationStatus;
import com.tags.cs451r_groupproject_backend.general.Copier;
import com.tags.cs451r_groupproject_backend.filetransfer.rest.ResponseFile;
import com.tags.cs451r_groupproject_backend.position.dto.PositionDTO;
import com.tags.cs451r_groupproject_backend.position.model.Position;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ApplicationDTO implements Copier<Application>  {
    private Long id;
    private String firstName;
    private String lastName;
    private Long studentId;
    private String umkcEmail;
    private String standing;
    private String graduatingSemester;
    private Double umkcGPA;
    private Long hoursDoneAtUmkc;
    private String undergraduateDegree;
    private String currentMajor;
    private List<String> desiredClasses;
    private List<String> desiredTypes;
    private ResponseFile file;
    private ApplicationStatus applicationStatus;

    private List<PositionDTO> positions = new ArrayList<>();

    public ApplicationDTO(Application application) {
        copyFrom(application);

        for(Position position : application.getPositions()) {
            PositionDTO positionDTO = new PositionDTO();
            positionDTO.copyFrom(position);
            positions.add(positionDTO);
        }
    }

    @Override
    public void copyFrom(Application entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.studentId =entity.getStudentId();
        this.umkcEmail =entity.getUmkcEmail();
        this.standing = entity.getStanding();
        this.graduatingSemester = entity.getGraduatingSemester();
        this.umkcGPA = entity.getUmkcGPA();
        this.hoursDoneAtUmkc = entity.getHoursDoneAtUmkc();
        this.undergraduateDegree = entity.getUndergraduateDegree();
        this.currentMajor = entity.getCurrentMajor();
        this.desiredClasses = entity.getDesiredClasses();
        this.desiredTypes = entity.getDesiredTypes();
        this.applicationStatus = entity.getApplicationStatus();

        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/files/")
                .path(String.valueOf(entity.getFile().getId()))
                .toUriString();

        this.file = new ResponseFile(
                entity.getFile().getName(),
                fileDownloadUri,
                entity.getFile().getType(),
                (long) entity.getFile().getData().length
        );
    }
}
