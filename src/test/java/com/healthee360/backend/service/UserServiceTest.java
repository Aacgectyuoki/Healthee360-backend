package com.healthee360.backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

import com.healthee360.backend.model.User;
import com.healthee360.backend.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldCreateUserSuccessfully() {
        // Arrange
        User newUser = new User();
        newUser.setName("Jane Doe");
        when(userRepository.save(any())).thenReturn(newUser);

        // Act
        User savedUser = userService.createUser(newUser);

        // Assert
        assertNotNull(savedUser, "The saved user should not be null.");
        assertEquals("Jane Doe", savedUser.getName(), "The user's name should match the one provided.");
    }

    @Test
    public void shouldReturnUserWhenIdExists() {
        // Arrange
        User expectedUser = new User();
        expectedUser.setId(1L);
        expectedUser.setName("John Doe");
        when(userRepository.findById(1L)).thenReturn(Optional.of(expectedUser));

        // Act
        User actualUser = userService.getUserById(1L);

        // Assert
        assertEquals("John Doe", actualUser.getName(), "The user's name should match the expected value.");
    }

    @Test
    public void shouldReturnNullWhenIdDoesNotExist() {
        // Arrange
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act
        User result = userService.getUserById(1L);

        // Assert
        assertNull(result, "No user should be found for a non-existing ID.");
    }
}
