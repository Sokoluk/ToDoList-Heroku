package ru.sokoluk.TodoList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sokoluk.TodoList.entity.Person;
import ru.sokoluk.TodoList.services.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/me")
    public ResponseEntity<Person> remember() {
        System.out.println("1111");
        return new ResponseEntity<>(authService.getRememberedPerson(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Person> authentication(@RequestBody Person person) {
        if (authService.isValidPerson(person))
            return new ResponseEntity<>(authService.getPerson(person), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/registration")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(authService.createPerson(person), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Person> logout(@RequestBody Person person) {
        return new ResponseEntity<>(authService.logout(person), HttpStatus.OK);
    }
}
