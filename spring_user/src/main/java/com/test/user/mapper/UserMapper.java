package com.test.user.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.user.dto.UserDto;
import com.test.user.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final ObjectMapper objectMapper;

    @Autowired
    public UserMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public UserDto convertToDTO(UserEntity userEntity) {
        return objectMapper.convertValue(userEntity, UserDto.class);
    }

    public List<UserDto> convertToDTOList(List<UserEntity> userEntityList) {
        return userEntityList.stream()
                .map(userEntity -> objectMapper.convertValue(userEntity, UserDto.class))
                .collect(Collectors.toList());
    }

    public Page<UserDto> convertToDTOPage(Page<UserEntity> userEntityPage) {
        return userEntityPage.map(userEntity -> objectMapper.convertValue(userEntity, UserDto.class));
    }

    public UserEntity convertToEntity(UserDto userDto) {
        return objectMapper.convertValue(userDto, UserEntity.class);
    }
}
