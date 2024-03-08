package com.example.baitap.controller;


import com.example.baitap.model.Computer;
import com.example.baitap.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("computer")
public class ComputerController {
    @Autowired
    private IComputerService iComputerService;
    @GetMapping
    public ResponseEntity<Iterable<Computer>> findAllCustomer(){
        List<Computer> computers = (List<Computer>) iComputerService.findAll();
        if (computers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(computers,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Computer> findComputerById(@PathVariable Long id){
        Optional<Computer> computer = iComputerService.findById(id);
        if (!computer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(computer.get(),HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Computer> saveComputer(@RequestBody Computer computer){
        return new ResponseEntity<>(iComputerService.save(computer), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable Long id, @RequestBody Computer computer){
        Optional<Computer> customerOptional = iComputerService.findById(id);
        if (!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(iComputerService.save(computer), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Computer> deleteComputer(@PathVariable Long id){
        Optional<Computer> computerOptional = iComputerService.findById(id);
        if (!computerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iComputerService.delete(id);
        return new ResponseEntity<>(computerOptional.get(), HttpStatus.OK);
    }
}