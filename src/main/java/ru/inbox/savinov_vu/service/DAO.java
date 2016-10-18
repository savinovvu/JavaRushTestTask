package ru.inbox.savinov_vu.service;

import ru.inbox.savinov_vu.entity.User;

import java.util.List;

/**
 * Created by skorpion on 07.08.16.
 */
 public interface DAO {
    void addUser(User user);
    void delete(int id);
    List<User> getByName(String name, int numberOfPage);
    void editUser(User user);
    List<User> getAll(int numberOfPage);
    User getById(int id);

}
