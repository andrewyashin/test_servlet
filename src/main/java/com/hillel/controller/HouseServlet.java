//package com.hillel.controller;
//
//import com.hillel.service.HouseService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/houses")
//public class HouseServlet extends HttpServlet {
//    private final HouseService houseService = new HouseService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("houses", houseService.findAllHouses());
//        req.getRequestDispatcher("views/houses.jsp").forward(req, resp);
//    }
//}
