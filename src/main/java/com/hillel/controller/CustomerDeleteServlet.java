package com.hillel.controller;

import com.hillel.dao.CustomerDao;
import com.hillel.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/delete")
public class CustomerDeleteServlet extends HttpServlet {
    private final CustomerDao customerDao = new CustomerDao();
    private final CustomerService customerService = new CustomerService(customerDao);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idForDelete = req.getParameter("id");

        customerService.delete(Integer.parseInt(idForDelete));

        req.setAttribute("customers", customerService.findAllCustomers());
        req.getRequestDispatcher("/views/customers.jsp").forward(req, resp);
    }
}
