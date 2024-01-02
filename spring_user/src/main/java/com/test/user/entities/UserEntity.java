package com.test.user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

;


@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "gmail", nullable = false)
    private String gmail;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
    @Column(name = "address", nullable = false)
    private String address;

    //    @JsonIgnore
//    ẩn hoàn toàn trường này
//    Hoặc
//    cho phép client gửi dữ liệu lên sever
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<StatusEntity> status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))

    private Set<RoleEntity> role = new HashSet<>();
    public UserEntity () {

    }
    public UserEntity( String userName, String passWord, String gmail, String phoneNumber, String address) {
        this.username = userName;
        this.password = passWord;
        this.gmail = gmail;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}

