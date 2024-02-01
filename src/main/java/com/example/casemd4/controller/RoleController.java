package com.example.casemd4.controller;

import com.example.casemd4.model.Role;
import com.example.casemd4.model.User;
import com.example.casemd4.repository.RoleRepository;
import com.example.casemd4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity<?> showList() {
        return new ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        roleRepository.findById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Role role) {
        return new ResponseEntity<>(roleRepository.save(role), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Role role, @PathVariable Long id) {
        role.setRoleId(id);
        return new ResponseEntity<>(roleRepository.save(role), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        roleRepository.deleteById(id);
        return new ResponseEntity("delete thanh cong", HttpStatus.OK);
    }
}
