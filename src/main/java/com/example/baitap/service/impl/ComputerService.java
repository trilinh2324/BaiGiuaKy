package com.example.baitap.service.impl;

import com.example.baitap.model.Computer;
import com.example.baitap.repository.IComputerRepository;
import com.example.baitap.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService implements IComputerService {
    @Autowired
    private IComputerRepository iComputerRepository;
    @Override
    public Iterable<Computer> findAll() {
        return iComputerRepository.findAll();
    }

    @Override
    public Optional<Computer> findById(int id) {
        return iComputerRepository.findById(id);;
    }

    @Override
    public Computer save(Computer computer) {
        return iComputerRepository.save(computer);
    }
    @Override
    public void delete(int id) {
        iComputerRepository.deleteById(id);
    }

}