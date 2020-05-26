package ru.af.mvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.af.service.dto.UserDto;
import ru.af.service.dto.UserService;
import ru.af.service.dto.WordDto;

import java.security.Principal;
import java.util.List;

@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        List<UserDto> userList = userService.getAllUsers();
        modelAndView.getModelMap().addAttribute("userList", userList);
        return modelAndView;
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrationpage");
        return modelAndView;
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public void addWord(@ModelAttribute("user") UserDto user) {
        userService.saveUser(user);

    }
}
