package com.simone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; // Import corretto

import com.simone.model.User;
import com.simone.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET) // Usa RequestMethod di Spring
    public String index(Model model) {
        model.addAttribute("items", userService.findAll());
        model.addAttribute("model", new User());
        return "user/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.POST) // Usa RequestMethod di Spring
    public String index(User input, Model model) {
        model.addAttribute("model", input);
        model.addAttribute("items", userService.search(input.getName()));
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET) // Usa RequestMethod di Spring
    public String add(Model model) {
        model.addAttribute("model", new User());
        return "user/form";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST) // Usa RequestMethod di Spring
    public String add(User input, Model model) {
        userService.save(input);
        return "redirect:/user/index";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET) // Usa RequestMethod di Spring
    public String edit(@PathVariable Long id, Model model) {
        User input = userService.find(id);
        model.addAttribute("model", input);
        return "user/form";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST) // Usa RequestMethod di Spring
    public String edit(User input, Model model) {
        userService.save(input);
        return "redirect:/user/index";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET) // Usa RequestMethod di Spring
    public String delete(@PathVariable Long id, Model model) {
        userService.delete(id);
        return "redirect:/user/index";
    }
}
