package com.ecommerce.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.repositories.IUserRepository;
import com.ecommerce.entities.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    IUserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @PostMapping("/saveUser")
    public User createUser(@RequestBody User user) { //anotação para especificar que o corpo da requisição deverá ser convertido para tipo User
        return userRepository.save(user);
    }

    @DeleteMapping
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
