package com.evaglass.controller;

import com.evaglass.entity.Customer;
import com.evaglass.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/customers/new")
    public String createCustomertForm(Model model) {
        //create customer object to hold customer data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create_customer";
    }

    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomerForm(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "edit_customer";
    }

    @PostMapping("/customers/{id}")
    public String updateCustomer(@PathVariable Integer id,
                                 @ModelAttribute("customer") Customer customer,
                                 Model model) {
        // get customer form database by id
        Customer existingCustomer=customerService.getCustomerById(id);
        existingCustomer.setId(id);
        existingCustomer.setName(customer.getName());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        existingCustomer.setEmail(customer.getEmail());

        //save update customer object
        customerService.updateCustomer(existingCustomer);
        return "redirect:/customers";
    }

    @GetMapping("customers/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }
}
