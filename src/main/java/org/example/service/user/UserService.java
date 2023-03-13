package org.example.service.user;

import org.example.dto.requests.UserRequestDto;
import org.example.dto.responses.UserResponseDto;
import org.example.models.UserEntity;
import org.example.service.BaseService;

public interface UserService extends BaseService<UserRequestDto, UserResponseDto, UserEntity> {
    UserResponseDto get(String phoneNumber);

    UserResponseDto setOwner();
}
