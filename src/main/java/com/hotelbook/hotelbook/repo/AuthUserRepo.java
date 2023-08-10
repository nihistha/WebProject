package com.hotelbook.hotelbook.repo;

import com.hotelbook.hotelbook.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

@Repository
public interface AuthUserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}