package com.spacoeducar.spacoeducar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spacoeducar.spacoeducar.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
