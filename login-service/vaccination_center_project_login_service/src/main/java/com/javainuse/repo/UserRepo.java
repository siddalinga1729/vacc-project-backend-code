package com.javainuse.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javainuse.model.DAOUser;


public interface UserRepo extends JpaRepository<DAOUser, Integer>{
}
