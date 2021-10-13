package com.hillel.controller;

import com.hillel.dto.CustomerDto;
import com.hillel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/app/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
//    @RequestMapping(method = RequestMethod.GET)
    public String customers(ModelMap modelMap) {
        modelMap.addAttribute("customers", customerService.findAllCustomers());
        return "customers";
    }


    @GetMapping("/delete")
    public String delete(ModelMap modelMap) {
        String idForDelete = (String) modelMap.getAttribute("id");

        customerService.delete(Integer.parseInt(idForDelete));

        modelMap.addAttribute("customers", customerService.findAllCustomers());

        return "customers";
    }

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST)
    public String save(ModelMap modelMap) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail((String) modelMap.getAttribute("email"));
        customerDto.setName((String) modelMap.getAttribute("name"));
        customerDto.setSurname((String) modelMap.getAttribute("surname"));
        customerService.save(customerDto);

        modelMap.addAttribute("customers", customerService.findAllCustomers());
        return "customers";
    }
}
