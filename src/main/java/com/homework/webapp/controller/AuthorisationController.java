package com.homework.webapp.controller;

import com.homework.webapp.dto.Role;
import com.homework.webapp.dto.User;
import com.homework.webapp.exception.NotFoundEntityException;
import com.homework.webapp.mapper.RoleMapper;
import com.homework.webapp.service.RoleService;
import com.homework.webapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorisationController {
    private final RoleService roleService;
    private final UserService userService;
    private final RoleMapper mapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

   @GetMapping(path = "/login")
    public String loginPage(){
       return "login";
    }

    @GetMapping(path = "/registration-form")
    public ModelAndView registerForm(){
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("registration_form");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @PostMapping("/registration")
    public String userRegistration(@ModelAttribute("user") User user) throws NotFoundEntityException {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleService.findOneById(2L);
        user.setRole(mapper.mapRoleToRoleEntity(role));
        userService.createOne(user);

        return "redirect:/";
    }
}
