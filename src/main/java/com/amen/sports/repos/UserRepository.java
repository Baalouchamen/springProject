package com.amen.sports.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import com.amen.sports.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
