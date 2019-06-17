package com.homework.webapp.controller;

import com.homework.webapp.dto.Manufacturer;
import com.homework.webapp.exception.NotFoundEntityException;
import com.homework.webapp.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{id}")
    public String getManufacturer(Model model, @PathVariable Long id) throws NotFoundEntityException {
        model.addAttribute(service.findOneById(id));
        return "redirect:/manufacturers/"+ id + "/products";
    }

    @PostMapping(path = "/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String createManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "edit_manufacturer";
    }

    @PostMapping(path = "/")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String saveManufacturer(@RequestBody Manufacturer manufacturer) {
        service.createOne(manufacturer);
        return "redirect:/manufacturers";
    }

    @PutMapping(path = "/edit/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String editManufacturer(Model model, @PathVariable Long id) throws Throwable {
        model.addAttribute("manufacturer", service.findOneById(id));
        return "edit_manufacturer";
    }

    @DeleteMapping(path = "/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String deleteManufacturer(@PathVariable Long id) {
        service.deleteOneById(id);
        return "redirect:/manufacturers";
    }
}
