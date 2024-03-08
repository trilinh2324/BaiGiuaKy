package com.example.baitap.service.impl;

import com.example.baitap.model.PerSon;
import com.example.baitap.repository.IPerSonRepository;
import com.example.baitap.service.IPerSonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerSonService implements IPerSonService {
    @Autowired
    private IPerSonRepository iPerSonRepository;

    @Override
    public Iterable findAll() {
        return iPerSonRepository.findAll();

    }

    @Override
    public Optional findById(int id) {
        return iPerSonRepository.findById(id);

    }

    @Override
    public PerSon save(PerSon perSon) {
        return iPerSonRepository.save(perSon);
    }


    @Override
    public void delete(int id) {
        iPerSonRepository.deleteById(id);
    }


}
