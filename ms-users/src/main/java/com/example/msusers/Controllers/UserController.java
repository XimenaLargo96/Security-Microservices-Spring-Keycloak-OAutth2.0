package com.example.msusers.Controllers;

import com.example.msusers.Service.UserService;
import com.example.msusers.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }
}
