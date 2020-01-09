package de.telran.blog.controller;

import de.telran.blog.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/api/post")
public class RegistrationController {

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }
}
