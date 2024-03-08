package com.example.baitap.service;


import com.example.baitap.model.Computer;

import java.util.Optional;

public interface IComputerService extends IGenerateService<Computer>{
    Optional<Computer> findById(Long id);

    void delete(Long id);
}