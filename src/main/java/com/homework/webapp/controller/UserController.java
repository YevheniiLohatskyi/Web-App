package com.homework.webapp.controller;

import com.homework.webapp.dto.User;
import com.homework.webapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/users")
//@PreAuthorize("hasAnyRole('ADMIN')")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService service;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> manufacturers = service.findAll();
        model.addAttribute("users", manufacturers);
        return "users";
    }

    @PostMapping(path = "/add")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "edit_user";
    }

    @PostMapping(path = "/")
    public String saveUser(@RequestBody User user) {
        service.createOne(user);
        return "redirect:/users";
    }

    @PutMapping(path = "/edit")
    public String editUser(Model model, @RequestParam Long id) throws Throwable {
        model.addAttribute("user", service.findOneById(id));
        return "edit_user";
    }

    @DeleteMapping(path = "/delete")
    public String deleteUser(@RequestParam Long id) {
        service.deleteOneById(id);
        return "redirect:/users";
    }
}
