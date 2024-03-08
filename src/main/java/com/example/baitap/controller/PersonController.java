package com.example.baitap.controller;

import com.example.baitap.model.PerSon;
import com.example.baitap.service.IPerSonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private IPerSonService iPersonService;
    @GetMapping
    public ResponseEntity<Iterable<PerSon>> findAllPerson(){
        List<PerSon> personList = (List<PerSon>) iPersonService.findAll();
        if (personList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(personList,HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<PerSon> findPersonById(@PathVariable Integer id){
        Optional<PerSon> person = iPersonService.findById(id);
        if (!person.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(person.get(),HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<PerSon> saveCustomer(@RequestBody PerSon person){
        return new ResponseEntity<>(iPersonService.save(person), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PerSon> updatePerson(@PathVariable Integer id, @RequestBody PerSon customer){
        Optional<PerSon> personOptional = iPersonService.findById(id);
        if (!personOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(personOptional.get().getId());
        return new ResponseEntity<>(iPersonService.save(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PerSon> deletePerson(@PathVariable Integer id){
        Optional<PerSon> personOptional = iPersonService.findById(id);
        if (!personOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iPersonService.delete(id);
        return new ResponseEntity<>(personOptional.get(), HttpStatus.OK);
    }


}
