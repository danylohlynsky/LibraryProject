package com.group4.controller;

import com.group4.model.Role;
import com.group4.model.User;
import com.group4.service.interfaces.RoleService;
import com.group4.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("")
public class SecurityController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public SecurityController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        Role role = roleService.listRoles().get(1);
        user.setRole(role);
        userService.saveUser(user);
        return "redirect:/login";
    }
}
