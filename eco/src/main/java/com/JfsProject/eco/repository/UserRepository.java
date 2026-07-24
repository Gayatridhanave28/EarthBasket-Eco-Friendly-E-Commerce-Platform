package com.JfsProject.eco.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JfsProject.eco.model.User;


@Repository
@Qualifier("userRepo")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
