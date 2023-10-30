package com.tags.cs451r_groupproject_backend.administrator.model;

import com.tags.cs451r_groupproject_backend.general.Copier;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "administrator")
@Data
@NoArgsConstructor
public class Administrator implements Copier<Administrator> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Override
    public void copyFrom(Administrator entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
    }
}
