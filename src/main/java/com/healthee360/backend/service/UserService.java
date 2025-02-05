package com.healthee360.backend.service;

import com.healthee360.backend.model.User;
import com.healthee360.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieve a user by their ID.
     *
     * @param id the ID of the user to retrieve
     * @return the found User or null if no user is found
     */
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    /**
     * Create or update a user.
     *
     * @param user the user to save or update
     * @return the saved user
     */
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Delete a user by their ID.
     *
     * @param id the ID of the user to delete
     */
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * List all users.
     *
     * @return a list of all users
     */
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    /**
     * Create a new user with initial settings.
     * This method assumes newUser is not null and has been validated.
     *
     * @param newUser the new user to create
     * @return the created user
     */
    @Transactional
    public User createUser(User newUser) {
        // Optionally, you can add here initial settings or validations if needed
        return userRepository.save(newUser);
    }
}