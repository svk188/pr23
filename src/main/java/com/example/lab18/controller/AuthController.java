package com.example.lab18.controller;

import com.example.lab18.entities.User;
import com.example.lab18.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration(Model model) {
        User newUser = new User();
        model.addAttribute("user", newUser);

        return "registration";
    }

    @PostMapping("/registration")
    public String reg(@ModelAttribute("user") User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        User userFrom = userRepository.findUserByLogin(newUser.getLogin());

        if (userFrom != null) {
            return "registration";
        }
        userRepository.save(newUser);

        return "redirect:login";
    }
}
