package com.projects.jobplatform.services;

import com.projects.jobplatform.modles.User;
import com.projects.jobplatform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new IllegalStateException(
                                "User with id " + userId + " does not exists")
                );
    }

    public User getUser(String userName) {
        return userRepository
                .findByUsername(userName)
                .orElseThrow(()->
                        new IllegalStateException( "User with Email: " + userName + " does not exists")
                );
    }

    public User addUser(User user) {

        userRepository.save(user);
        return user;
    }

    public boolean deleteUser(Long userId) {
        User user = getUser(userId);
        userRepository.deleteById(userId);
        return true;
    }

    public boolean deleteUser(String userName) {
        User user = getUser(userName);
        return userRepository.deleteByUsername(userName);
    }

    @Transactional
    public User updateUser(Long userId, User user) {
        User oldUser = getUser(userId);
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        return oldUser;
    }

    @Transactional
    public User updateUser(String email, User user) {
        User oldUser = getUser(email);
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        return oldUser;
    }

}
