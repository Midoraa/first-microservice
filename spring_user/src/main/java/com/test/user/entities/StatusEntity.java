package com.test.user.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "status")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @JsonCreator
    public static StatusEntity fromString(String title) {
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.title = title;
        return statusEntity;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;


}
