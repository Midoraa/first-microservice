package com.test.user.repository;

import com.test.user.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);
    List<UserEntity> findByUsernameContaining(String username);

    Boolean existsByUsername (String username);
    Page<UserEntity> findByUsernameContainingIgnoreCase (String username, PageRequest pageable);
}
