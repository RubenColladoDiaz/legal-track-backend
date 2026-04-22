package com.main.legaltrackbackend.repositories;

import com.main.legaltrackbackend.models.auth.User;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
