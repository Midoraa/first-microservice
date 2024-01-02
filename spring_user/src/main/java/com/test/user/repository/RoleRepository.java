package com.test.user.repository;


import com.test.user.entities.ERole;
import com.test.user.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByRole(ERole role);
}
