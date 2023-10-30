package com.tags.cs451r_groupproject_backend.general;

import lombok.*;

@NoArgsConstructor
@Data
public class ErrorResponse {
    private Integer status;
    private String message;
    private Long timeStamp;
}
