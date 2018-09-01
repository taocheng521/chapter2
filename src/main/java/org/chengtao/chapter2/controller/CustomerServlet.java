package org.chengtao.chapter2.controller;

import org.chengtao.chapter2.model.Customer;
import org.chengtao.chapter2.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;


    @Override
    public void init() throws ServletException{
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    throws ServletException, IOException {
        List<Customer> customerList = customerService.getCustomerList();
        httpServletRequest.setAttribute("customerList", customerList);
        httpServletRequest.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(httpServletRequest, httpServletResponse);

    }

}
