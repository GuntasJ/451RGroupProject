package com.tags.cs451r_groupproject_backend.filetransfer.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class FilePostResponse {
    private Long id;
    private String message;
}
