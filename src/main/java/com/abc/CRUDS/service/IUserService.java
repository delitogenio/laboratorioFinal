package com.abc.CRUDS.service;

import com.abc.CRUDS.model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    Optional<User> findById(Long id);
    List<User> listAll();

    User create (User user);

    User update(User user);

    boolean delete (Long userId);

    Optional<User> findByEmail(String email);

    Optional<List<User>> findByCumpleanos(Date from, Date to);

}
