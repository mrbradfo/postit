package org.postit.services;

import org.postit.exceptions.AppError;
import org.postit.models.User;
import org.postit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new AppError(HttpStatus.NOT_FOUND, "User not found"));
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        Optional<User> existingUser = userRepository.getByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new AppError(HttpStatus.UNPROCESSABLE_ENTITY, "The username " + user.getUsername() + " is already taken.");
        }
        return userRepository.save(user);
    }
}
