package com.abc.CRUDS.controller;

import com.abc.CRUDS.model.User;
import com.abc.CRUDS.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Users")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping(value = "/email/{email}")
    public Optional<User> findUserByEmail(@PathVariable("email") String email){
        return service.findByEmail(email);
    }

    @GetMapping(value = "/Cumpleanos/{from}/{to}")
    public Optional<List<User>> findByCumpleanos(
            @PathVariable("from")@DateTimeFormat(pattern = "yyyy-MM-dd")Date from,
            @PathVariable("to")@DateTimeFormat(pattern = "yyyy-MM-dd")Date to
            ){
        return service.findByCumpleanos(from, to);
    }

    @GetMapping(value = "/{id}")
    public Optional<User> findUserById(@PathVariable ("id") Long id){
        return service.findById(id);
    }


    @GetMapping("/all")
    public List<User> listAll(){
        return service.listAll();
    }

    @PostMapping
    public User create (@RequestBody User user){
        return service.create(user);
    }

    @PutMapping
    public User update (@RequestBody User user){
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return service.delete(id);
    }


}
