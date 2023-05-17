package com.projects.jobplatform.repositories;

import com.projects.jobplatform.modles.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String userName);

    boolean deleteByUsername(String userName);
}
