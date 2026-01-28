package com.penumper.service;

import com.penumper.exception.EmailAlreadyExistsException;
import com.penumper.exception.UserNotFoundException;
import com.penumper.model.User;
import com.penumper.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateUserSuccessfully() {
        User user = new User(null, "João Silva", "joao@email.com");
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(new User(1L, "João Silva", "joao@email.com"));

        User created = userService.createUser(user);

        assertNotNull(created.getId());
        assertEquals(user.getEmail(), created.getEmail());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void shouldThrowExceptionWhenEmailAlreadyExists() {
        User user = new User(null, "João Silva", "joao@email.com");
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(new User(1L, "Existente", "joao@email.com")));

        assertThrows(EmailAlreadyExistsException.class, () -> userService.createUser(user));
        verify(userRepository, never()).save(any());
    }

    @Test
    void shouldFindUserById() {
        User user = new User(1L, "João Silva", "joao@email.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User found = userService.getUserById(1L);

        assertEquals(1L, found.getId());
        assertEquals("João Silva", found.getName());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.getUserById(1L));
    }
}
