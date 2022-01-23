package com.inpt.projet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.inpt.projet.Clients.Books;

@Repository
public interface BookRepository extends JpaRepository<Books,Long>{

}
