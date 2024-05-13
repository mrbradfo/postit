package org.postit.services;

import org.postit.models.User;


public interface UserService {
    User getUserById(int userId);

    Iterable<User> getUsers();

    User createUser(User user);
}