package com.example.msusers.Repository;

import com.example.msusers.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {

    Optional<User> findUserByCustomerId(String id);
}
