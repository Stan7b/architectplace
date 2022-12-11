package com.architect.api.ArchitectPlace.dto;

import com.architect.api.ArchitectPlace.entity.Gender;
import com.architect.api.ArchitectPlace.entity.Project;
import com.architect.api.ArchitectPlace.entity.enums.UserStatus;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {

    private Long id;

    private String email;

    private String username;

    private Integer age;

    private UserStatus userStatus;

    private Gender gender;

    private List<Project> projects;

}
