package com.gestion.assignationvoiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gestion.assignationvoiture.model.Customer;
import com.gestion.assignationvoiture.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("customers", service.getAll());
        return "customer/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer obj) {
        service.save(obj);
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", service.getById(id));
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Customer obj) {
        service.save(obj);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/customer";
    }

}