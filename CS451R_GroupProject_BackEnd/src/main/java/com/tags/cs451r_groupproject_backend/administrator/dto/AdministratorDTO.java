package com.tags.cs451r_groupproject_backend.administrator.dto;

import com.tags.cs451r_groupproject_backend.administrator.model.Administrator;
import com.tags.cs451r_groupproject_backend.general.Copier;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AdministratorDTO implements Copier<Administrator> {
    private Long id;
    private String username;

    public AdministratorDTO(Administrator administrator) {
        copyFrom(administrator);
    }

    @Override
    public void copyFrom(Administrator entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
    }
}
