package com.example.sb2.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb2.model.Employee;
import com.example.sb2.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")

public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/showid/{id}")
    public ResponseEntity<Employee> showid(@PathVariable Long id){
        Optional<Employee>_showid=employeeRepository.findById(id);
        if(_showid.isPresent()){
            return new ResponseEntity<>(_showid.get(),HttpStatus.OK );
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteid(@PathVariable Long id){
        employeeRepository.deleteAllById(null);;
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
