package com.test.user.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.test.user.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusDto {
    private Long id;
    private String title;
    private UserEntity user;
    @JsonCreator
    public static StatusDto fromString(String title) {
        StatusDto statusDto = new StatusDto();
        statusDto.title = title;
        return statusDto;
    }
}