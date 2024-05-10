package org.postit.controllers;

import org.postit.models.User;
import org.postit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public @ResponseBody Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping()
    public @ResponseBody User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}
