package ua.goit.java.dev6.hw8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.goit.java.dev6.hw8.model.Dto.UserDto;
import ua.goit.java.dev6.hw8.service.RoleService;
import ua.goit.java.dev6.hw8.service.UserService;


import java.util.Collections;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String signup() {
        return "signup/signup";
    }

    @PostMapping
    public String signup(@ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup/signup";
        }
        if (userService.isExistEmail(userDto.getEmail())){
            bindingResult.addError(new ObjectError("email", "Email already in use"));
            return "signup/signup";
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userDto.setEmail(userDto.getEmail().toLowerCase());
        userDto.setRoles(Collections.singletonList(roleService.findByName("ROLE_USER")));
        userService.create(userDto);
        return "redirect:/home";

    }

    @ModelAttribute("user")
    private UserDto getDefaultProduct() {
        return new UserDto();
    }

}
