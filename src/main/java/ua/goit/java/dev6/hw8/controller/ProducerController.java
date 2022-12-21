package ua.goit.java.dev6.hw8.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.dev6.hw8.model.Dto.ProducerDto;
import ua.goit.java.dev6.hw8.service.ProducerService;


import java.util.UUID;

@Controller
@RequestMapping("/producers")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @GetMapping
    public ModelAndView getProducers() {
        ModelAndView result = new ModelAndView("producers/producers");
        result.addObject("producers", producerService.findAll());
        return result;
    }

    @Secured(value = "ROLE_ADMIN")
    @GetMapping("/create")
    public String getCreateForm() {
        return "producers/createProducerForm";
    }

    @GetMapping("/{id}")
    public ModelAndView getProducersById(@PathVariable("id") UUID id) {
        ModelAndView result = new ModelAndView("producers/producerEditForm");
        result.addObject("producer", producerService.get(id));
        return result;
    }

    @Secured(value = "ROLE_ADMIN")
    @PutMapping("/{id}")
    public String update(@Valid @RequestBody ProducerDto producerDto, BindingResult result, @PathVariable("id") UUID id) {
        if (result.hasErrors()) {
            return "producers/producerEditForm";
        }
        producerService.update(id, producerDto);
        return "producers/producers";
    }

    @Secured(value = "ROLE_ADMIN")
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("producer") ProducerDto producerDto, BindingResult result) {
        if (result.hasErrors()) {
            return "producers/createProducerForm";
        }
        UUID id = producerService.create(producerDto);
        return "redirect:/producers/" + id;
    }

    @Secured(value = "ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") UUID id) {
        producerService.delete(id);
        return getProducers();
    }

    @ModelAttribute("producer")
    public ProducerDto getDefaultProducer() {
        return new ProducerDto();
    }

}
