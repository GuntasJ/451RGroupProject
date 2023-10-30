package com.tags.cs451r_groupproject_backend.filetransfer.model;

import com.tags.cs451r_groupproject_backend.general.Copier;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileDTO implements Copier<File>  {
    private Long id;
    private String name;
    private String type;
    private byte[] data;

    public FileDTO(File file) {
        copyFrom(file);
    }

    @Override
    public void copyFrom(File entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.type = entity.getType();
        this.data = entity.getData();
    }
}
