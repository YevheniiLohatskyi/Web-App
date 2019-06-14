package com.homework.webapp.controller;

import com.homework.webapp.dto.Manufacturer;
import com.homework.webapp.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/manufacturers")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ManufacturerController {
    private final ManufacturerService service;

    @GetMapping(path = "/")
    public String getAllManufacturers(Model model) {
        List<Manufacturer> manufacturers = service.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "manufacturers";
    }

    @GetMapping(path = "/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String createManufacturer(@Valid Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "edit";
    }

    @PostMapping(path = "/")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String saveManufacturer(@RequestBody Manufacturer manufacturer) {
        service.createOne(manufacturer);
        return "redirect:/";
    }

    @GetMapping(path = "/edit")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String editManufacturer(@Valid Model model, @RequestParam Long id) throws Throwable {
        model.addAttribute("manufacturer", service.findOneById(id));
        return "edit";
    }

    @DeleteMapping(path = "/delete")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String deleteManufacturer(@RequestParam Long id) {
        service.deleteOneById(id);
        return "redirect:/manufacturers";
    }
}
