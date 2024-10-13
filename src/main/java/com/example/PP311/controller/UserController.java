package com.example.PP311.controller;

import com.example.PP311.model.User;
import com.example.PP311.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    final private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/edit")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        if(user.getId() != null) {
            model.addAttribute("user", userService.getUserById(user.getId()));
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit.html";
        } else {
            if (user.getId() == null) {
                userService.saveUser(user);
            } else {
                userService.updateUser(user);
            }
            return "redirect:/users";
        }
    }

    @PostMapping("/del")
    public String deleteUser(@ModelAttribute("user") User user) {
            userService.removeUserById(user.getId());
        return "redirect:/users";
    }
}