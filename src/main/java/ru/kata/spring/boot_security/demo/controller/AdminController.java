package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private UserService userService;
    private RoleService roleService;


    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }
    @GetMapping("/new")
    public String newUserForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("roles",roleService.getAllRoles());
        return "newUser";
    }
    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("user") @Valid User user,BindingResult bindingResult){
    if (bindingResult.hasErrors()){
        return "/newUser";
    }
    userService.save(user);
    return "redirect:/admin";
    }
    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user",userService.getById(id));
        model.addAttribute("roles",roleService.getAllRoles());
        return "edit";
    }
    @PatchMapping("/edit")
    public String update2(@ModelAttribute("user") @Valid User user,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/edit";
        }
        userService.update(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/admin";
    }
}
