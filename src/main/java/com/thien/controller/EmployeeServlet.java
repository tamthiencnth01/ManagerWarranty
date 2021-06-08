package com.thien.controller;

import com.thien.dao.EmployeeDao;
import com.thien.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@MultipartConfig
@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID  = 1L;
    private EmployeeDao employeeDao;
    public void init(){
        employeeDao = new EmployeeDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                try {
                    showEditForm(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteEmployee(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                try {
                    showListEmployee(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDao.deleteEmp(id);
        List<Employee> list = employeeDao.selectAllEmp();
        request.setAttribute("employees",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDao.selectEmpById(id);
        request.setAttribute("check",employee);
        List<Employee> list = employeeDao.selectAllEmp();
        request.setAttribute("employees",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Employee> list = employeeDao.selectAllEmp();
        request.setAttribute("employees",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String action = request.getParameter("action");
        if (action==null) {
            action = "";
        }switch (action){
            case "create":
                try {
                    try {
                        createService(request,response);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editService(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String dob =request.getParameter("dob");
        String gender = request.getParameter("gender");
        String nation = request.getParameter("nation");
        String phone = request.getParameter("phone");
        String image = request.getParameter("image64");
        employeeDao.updateEmp(name,address,dob,gender,nation,phone,image,id);
        List<Employee> list = employeeDao.selectAllEmp();
        request.setAttribute("employees",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ParseException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String dob =request.getParameter("dob");
        String gender = request.getParameter("gender");
        String nation = request.getParameter("nation");
        String phone = request.getParameter("phone");
        String image = request.getParameter("image64");
        employeeDao.insertEmp(name,address,dob,gender,nation,phone,image);
        List<Employee> list = employeeDao.selectAllEmp();
        request.setAttribute("employees",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);
    }
}
