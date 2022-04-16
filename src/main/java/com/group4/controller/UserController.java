package com.group4.controller;
import com.group4.model.User;
import com.group4.service.MailSender;
import com.group4.service.interfaces.RoleService;
import com.group4.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String listUser(Model model) {
        model.addAttribute("users", this.userService.listUser());
        return "list-users";
    }

    @GetMapping("/add")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleService", roleService);
        return "create-user";
    }

    @PostMapping("/add")
    public String createUser(@Validated @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()){
            return "create-user";
        }

        userService.saveUser(user);
        return "redirect:/users";
    }



    @GetMapping("/remove/{id}")
    public RedirectView deleteUser(@PathVariable("id") int id) {
        this.userService.deleteUser(userService.findById(id));
        return new RedirectView("/users");
    }

    private List<String> emails = new ArrayList<>();
    @PostMapping("/send-email")
    public String SendEmail(@RequestParam(value="title") String title, @RequestParam(value="message") String message) {
        MailSender.sendEmail(emails, title, message);
        emails.clear();
        return "redirect:/users";
    }

    @GetMapping("/send-email/{id}")
    public String sendMailUser(@PathVariable("id") int id) {
        emails.add(userService.findById(id).getEmail());
        return "email";
    }

    @GetMapping("/send-email-all")
    public String sendMailAllUsers() {
        emails.addAll(userService.listUser().stream().map(User::getEmail).collect(Collectors.toList()));
        return "email";
    }
/*
    @PostMapping("/send-email-all")
    public String sendAllPost(@RequestParam(value="title") String title, @RequestParam(value="message") String message) {
        List<String> emailAdd = new ArrayList<>();
        emailAdd.addAll(userService.listUser().stream().map(User::getEmail).collect(Collectors.toList()));
        MailSender.sendEmail(emailAdd, title, message);
        return "redirect:/users";
    }
*/

    @GetMapping("/user-date/{id}")
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));

        return "user-info";
    }
    @GetMapping("/user-update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "update-user";
    }

//    @GetMapping("/user-update/{id}")
//    public String updateUserForm(@PathVariable("id") int id, Model model) {
//        User user = userService.findById(id);
//        model.addAttribute("user", user);
//        return "update-user";
//    }
//
//    @PostMapping("/user-update")
//    public String updateUser(User user) {
//        userService.saveUser(user);
//        return "redirect:/users";
//    }



}
