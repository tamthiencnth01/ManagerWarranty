package com.thien.controller;

import com.thien.dao.CustomerDao;
import com.thien.model.Customer;
import com.thien.model.Employee;
import com.thien.model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID  = 1L;
    private CustomerDao customerDao;
    public void init(){
        customerDao = new CustomerDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String action = request.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "edit":
                try {
                    showEditForm(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteCustomer(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                try {
                    showSearchForm(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showListCustomer(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerDao.deleteCustomer(id);
        List<Customer> list = customerDao.selectAllCustomer();
        request.setAttribute("customers",list);
        List<Service> serviceList = customerDao.selectAllServices();
        request.setAttribute("services",serviceList);
        List<Employee> employeeList = customerDao.selectAllEmployees();
        request.setAttribute("employees",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerDao.selectCustomer(id);
        request.setAttribute("check",customer);
        List<Customer> list = customerDao.selectAllCustomer();
        request.setAttribute("customers",list);
        List<Service> serviceList = customerDao.selectAllServices();
        request.setAttribute("services",serviceList);
        List<Employee> employeeList = customerDao.selectAllEmployees();
        request.setAttribute("employees",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> list = customerDao.selectAllCustomer();
        request.setAttribute("customers",list);
        List<Service> serviceList = customerDao.selectAllServices();
        request.setAttribute("services",serviceList);
        List<Employee> employeeList = customerDao.selectAllEmployees();
        request.setAttribute("employees",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyWord = request.getParameter("keyWord");
        List<Customer> list = customerDao.searchLike(keyWord);
        request.setAttribute("customers",list);
        List<Service> serviceList = customerDao.selectAllServices();
        request.setAttribute("services",serviceList);
        List<Employee> employeeList = customerDao.selectAllEmployees();
        request.setAttribute("employees",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }


    protected void doPost(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String action = request.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "create":
                try {
                    createCustomer(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateCustomer(request,response);
                } catch (SQLException | ServletException | IOException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fullName = request.getParameter("name");
        String address  =request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String description = request.getParameter("description");
        int quantities = Integer.parseInt(request.getParameter("quantities"));
        String nameEmp = request.getParameter("nameEmp");
        Customer newCustomer = new Customer(id, fullName,address,email,phone,description,nameEmp,quantities);
        customerDao.updateCustomer(newCustomer);
        List<Customer> list = customerDao.selectAllCustomer();
        request.setAttribute("customers",list);
        List<Service> serviceList = customerDao.selectAllServices();
        request.setAttribute("services",serviceList);
        List<Employee> employeeList = customerDao.selectAllEmployees();
        request.setAttribute("employees",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = (int) (Math.random()*10000);
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String description = request.getParameter("description");
        String nameEmp = request.getParameter("nameEmp");
        int quantities = Integer.parseInt(request.getParameter("quantities"));
        Customer customer = new Customer(id, name, address, email, phone,description,nameEmp,quantities);
        customerDao.insertCustomer(customer);
        List<Customer> list = customerDao.selectAllCustomer();
        request.setAttribute("customers",list);
        List<Service> serviceList = customerDao.selectAllServices();
        request.setAttribute("services",serviceList);
        List<Employee> employeeList = customerDao.selectAllEmployees();
        request.setAttribute("employees",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }
}
