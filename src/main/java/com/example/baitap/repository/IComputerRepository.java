package com.example.baitap.repository;


import com.example.baitap.model.Computer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComputerRepository extends CrudRepository<Computer,Long> {
}