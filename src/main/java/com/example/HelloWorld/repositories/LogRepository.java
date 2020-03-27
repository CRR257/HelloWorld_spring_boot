package com.example.HelloWorld.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HelloWorld.entities.Log;;

@Repository
public interface LogRepository extends JpaRepository<Log, Long>  {

}
