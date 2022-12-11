package com.architect.api.ArchitectPlace.utils;

import com.architect.api.ArchitectPlace.dto.UserRequestDto;
import com.architect.api.ArchitectPlace.dto.UserResponseDto;
import com.architect.api.ArchitectPlace.entity.User;
import com.architect.api.ArchitectPlace.entity.enums.UserStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    @Mapping(source = "userStatus", target = "userStatus")
    User userRequestToUser(UserRequestDto userRequestDto, UserStatus userStatus);


    @Mapping(source = "gender.name", target = "genderName")
    UserResponseDto userToUserResponse(User user);

}
