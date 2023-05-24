package com.abc.CRUDS.service;


import com.abc.CRUDS.model.User;
import com.abc.CRUDS.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public Optional<User> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public List<User> listAll(){
        return repository.findAll();
    }

    @Override
    public User create (User user){
        return repository.save(user);
    }

    @Override
    public User update(User user){
        if (user.getId() == null){
            return  user;
        }

        User userDb = repository.findById(user.getId()).orElse(user);

        if (user.getNombre() != null){
            userDb.setNombre(user.getNombre());
        }
        if (user.getApellido() != null){
            userDb.setApellido(user.getApellido());
        }
        if (user.getEmail() != null){
            userDb.setEmail(user.getEmail());
        }
        if (user.getEdad() != null){
            userDb.setEdad(user.getEdad());
        }
        if (user.getCumpleanos() != null){
            userDb.setCumpleanos(user.getCumpleanos());
        }
        repository.save(userDb);
        return userDb;

    }

    @Override
    public boolean delete(Long userId) {
        return repository.findById(userId).map(user -> {
            repository.delete(user);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<List<User>> findByCumpleanos(Date from, Date to) {
        return repository.findByCumpleanosBetween(from,to);
    }
}
