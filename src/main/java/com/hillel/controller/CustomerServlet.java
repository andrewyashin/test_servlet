package com.hillel.controller;

import com.hillel.dao.CustomerDao;
import com.hillel.dto.CustomerDto;
import com.hillel.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomerServlet extends HttpServlet {
    private final CustomerDao customerDao = new CustomerDao();
    private final CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            String idForDelete = req.getParameter("id");
            customerService.delete(Integer.parseInt(idForDelete));
        }
        req.setAttribute("customers", customerService.findAllCustomers());
        req.getRequestDispatcher("views/customers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail(req.getParameter("email"));
        customerDto.setName(req.getParameter("name"));
        customerDto.setSurname(req.getParameter("surname"));
        customerService.save(customerDto);
        req.setAttribute("customers", customerService.findAllCustomers());
        req.getRequestDispatcher("views/customers.jsp").forward(req, resp);
    }
}
