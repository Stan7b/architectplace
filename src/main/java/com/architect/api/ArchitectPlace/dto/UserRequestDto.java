package com.architect.api.ArchitectPlace.dto;

import com.architect.api.ArchitectPlace.entity.Gender;

import com.architect.api.ArchitectPlace.entity.User;

import lombok.Data;

@Data
public class UserRequestDto {

    private String username;

    private String password;

    private String email;

    private Integer age;

    private Gender gender;

}
