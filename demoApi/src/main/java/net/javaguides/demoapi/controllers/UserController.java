package net.javaguides.demoapi.controllers;

import net.javaguides.demoapi.models.UserModel;
import net.javaguides.demoapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }
    @GetMapping(path = "/{id}")
    public Optional<UserModel>getUserById(@PathVariable long id) {
        return this.userService.getUserById(id);
    }
    @PutMapping(path = "/{id}")
    public UserModel updateUser(@RequestBody UserModel user, @PathVariable("id") long id) {
        return this.userService.updateById(user, id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        boolean ok = this.userService.deleteById(id);
        if (ok) {
            return "User with id: "+ id+" deleted";
        }
        else
            return "Error while deleting user";
    }
}