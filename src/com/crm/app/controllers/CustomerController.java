package com.crm.app.controllers;

import com.crm.app.dao.CustomerDAO;
import com.crm.app.entities.Customer;
import com.crm.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
//	@RequestMapping(path="/list")
	@GetMapping(path="/list")
	public String listCustomers(Model model) {

		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);

		return "list-customers";
	}

	@GetMapping(value = "/showFormForAdd")
	public String showFormForAddCustomer(Model model) {

		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping(value = "/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String getCustomer(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam(name = "customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}

	@GetMapping(value = "/search")
	public String searchCustomers(@RequestParam(name = "name") String name, Model model) {
		List<Customer> customers = customerService.searchCustomers(name);
		model.addAttribute("customers", customers);
		return "list-customers";
	}
}
