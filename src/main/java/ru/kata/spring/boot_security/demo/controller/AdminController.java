package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dto.UserDto;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private UserService userService;
    private RoleService roleService;
    private UserDto userDto;


    public AdminController(UserService userService, RoleService roleService,UserDto userDto) {
        this.userService = userService;
        this.roleService = roleService;
        this.userDto = userDto;
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }
    @GetMapping("/new")
    public String newUserForm(Model model){
        model.addAttribute("user",new UserDto());
        model.addAttribute("roles",roleService.getAllRoles());
        return "newUser";
    }
    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("user") @Valid UserDto userDto,BindingResult bindingResult){
    if (bindingResult.hasErrors()){
        return "/newUser";
    }

    userService.save(userDto);


    return "redirect:/admin";
    }
    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user",userService.getById(id));
        model.addAttribute("roles",roleService.getAllRoles());
        return "edit";
    }
    @PatchMapping("/edit")
    public String update2(@ModelAttribute("user") @Valid UserDto userDto,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/edit";
        }

        userService.update(userDto);

        return "redirect:/admin";
    }
    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/admin";
    }
}
