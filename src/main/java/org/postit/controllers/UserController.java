package org.postit.controllers;

import jakarta.validation.Valid;
import org.postit.models.User;
import org.postit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public @ResponseBody Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping()
    public @ResponseBody User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

}
