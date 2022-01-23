package com.inpt.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inpt.projet.Clients.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

}
