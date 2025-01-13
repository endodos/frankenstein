package com.endorodrigo.frankenstein.controller;

import com.endorodrigo.frankenstein.entity.Customer;
import com.endorodrigo.frankenstein.repository.CustomerRepository;
import com.endorodrigo.frankenstein.servicies.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@Slf4j
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    

    // Mostrar todos los clientes
    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("customer", new Customer());
        return "home";
    }

    // Guardar un nuevo cliente o actualizar uno existente
    @PostMapping
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        log.info("=== creando customer ==");
        log.info(customer.toString());
        return "redirect:/home";
    }

    // Editar un cliente
    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") Integer id, Model model) {
        Customer customer = customerService.findById(id).orElseThrow();
        model.addAttribute("customer", customer);
        model.addAttribute("customers", customerService.findAll());
        return "customerForm";
    }

    // Eliminar un cliente
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }
}
