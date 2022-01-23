package com.inpt.projet.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.inpt.projet.Clients.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
