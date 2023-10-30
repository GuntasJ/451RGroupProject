package com.tags.cs451r_groupproject_backend.filetransfer.model;

import com.tags.cs451r_groupproject_backend.general.Copier;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "file")
@NoArgsConstructor
@Data
public class File implements Copier<File> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @Column(name = "file_name")
    private String name;

    @Column(name = "file_type")
    private String type;

    @Column(name = "file_data", columnDefinition = "LONGBLOB")
    @Lob
    private byte[] data;

    public File(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    @Override
    public void copyFrom(File entity) {
        this.id = entity.id;
        this.name = entity.name;
        this.type = entity.type;
        this.data = entity.data;
    }
}
