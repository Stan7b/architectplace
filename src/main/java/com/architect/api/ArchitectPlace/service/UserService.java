package com.architect.api.ArchitectPlace.service;

import com.architect.api.ArchitectPlace.dto.UserRequestDto;
import com.architect.api.ArchitectPlace.dto.UserResponseDto;
import com.architect.api.ArchitectPlace.entity.User;
import com.architect.api.ArchitectPlace.entity.enums.UserStatus;
import com.architect.api.ArchitectPlace.repo.UserRepo;
import com.architect.api.ArchitectPlace.utils.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepo userRepo;

    @Transactional
    UserResponseDto create(UserRequestDto userRequestDto) {
        User user = userMapper.userRequestToUser(userRequestDto, UserStatus.ACTIVE);
        userRepo.save(user);
        UserResponseDto userResponseDto = userMapper.userToUserResponse(user);
        return userResponseDto;
    }

    @Transactional
    UserResponseDto create2(UserRequestDto userRequestDto) {
        return Optional.of(userRequestDto)
                .map(ureq -> userMapper.userRequestToUser(userRequestDto, UserStatus.ACTIVE))
                .map(user -> userRepo.save(user))
                .map(user -> userMapper.userToUserResponse(user))
                .orElseThrow(() -> new ArithmeticException());
    }

    @Transactional
    UserResponseDto create3(UserRequestDto userRequestDto) {
        return Optional.of(userRequestDto)
                .map(ureq -> userMapper.userRequestToUser(userRequestDto, UserStatus.ACTIVE))
                .map(userRepo::save)
                .map(userMapper::userToUserResponse)
                .orElseThrow(ArithmeticException::new);
    }

    
    List<UserResponseDto> findAll() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::userToUserResponse)
                .collect(Collectors.toList());

    }


}
