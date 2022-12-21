package ua.goit.java.dev6.hw8.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.dev6.hw8.model.Dto.UserDto;
import ua.goit.java.dev6.hw8.service.RoleService;
import ua.goit.java.dev6.hw8.service.UserService;


import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
//@PreAuthorize("ROLE_ADMIN")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @GetMapping
    public ModelAndView getUsers() {
        ModelAndView result = new ModelAndView("users/users");
        result.addObject("users", userService.findAll());
        return result;
    }

    @GetMapping("/create")
    public ModelAndView getCreateForm() {
        ModelAndView result = new ModelAndView("users/createUserForm");
        result.addObject("roles", roleService.findAll());
        return result;
    }

    @GetMapping("/{id}")
    public ModelAndView getUserById(@PathVariable("id") UUID id) {
        ModelAndView result = new ModelAndView("users/userEditForm");
        result.addObject("user", userService.get(id));
        result.addObject("roles", roleService.findAll());

        return result;
    }

    @PostMapping("/{id}")
    public String update(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result,
                         @PathVariable("id") UUID id) {
        if (result.hasErrors()) {
            return "users/userEditForm";
        }
        if (Objects.nonNull(userDto.getPassword()) & !userDto.getPassword().isEmpty() & !userDto.getPassword().isBlank()){
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        } else {
            userDto.setPassword(userService.get(id).getPassword());
        }
        userDto.setEmail(userDto.getEmail().toLowerCase());
        userService.update(id, userDto);
        return "redirect:/users";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") UserDto userDto,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "users/createUserForm";
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UUID id = userService.create(userDto);
        return "redirect:/users/" + id;
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") UUID id) {
        userService.delete(id);
        return getUsers();
    }

    @ModelAttribute("user")
    private UserDto getDefaultProduct() {
        return new UserDto();
    }
}
