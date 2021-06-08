package com.thien.controller;

import com.thien.dao.CustomerDao;
import com.thien.dao.ServiceDao;
import com.thien.model.Customer;
import com.thien.model.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID  = 1L;
    private ServiceDao serviceDao;
    public void init(){
        serviceDao = new ServiceDao();
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
                showEditForm(request,response);
                break;
            case "delete":
                try {
                    deleteServices(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search":
                showSearchForm(request,response);
                break;
            default:
                showListService(request,response);
                break;
        }
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyWord = request.getParameter("keyWord");
        List<Service> list = serviceDao.searchLike(keyWord);
        request.setAttribute("services",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteServices(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceDao.deleteService(id);
        List<Service> list = serviceDao.selectAllService();
        request.setAttribute("services",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = serviceDao.selectService(id);
        request.setAttribute("check",service);
        List<Service> list = serviceDao.selectAllService();
        request.setAttribute("services",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> list = serviceDao.selectAllService();
        request.setAttribute("services",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
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
                    createService(request,response);
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

    private void editService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String description = request.getParameter("description");
        String unit = request.getParameter("unit");
        int quantities = Integer.parseInt(request.getParameter("quantities"));
        double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
        double amount = quantities*unitPrice;
        Service service = new Service(id,description,unit,quantities,unitPrice,amount);
        serviceDao.updateService(service);
        List<Service> list = serviceDao.selectAllService();
        request.setAttribute("services",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request,response);
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String description = request.getParameter("description");
        String unit = request.getParameter("unit");
        int quantities = Integer.parseInt(request.getParameter("quantities"));
        double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
        double amount = quantities*unitPrice;
        Service service = new Service(description,unit,quantities,unitPrice,amount);
        serviceDao.insertService(service);
        List<Service> list = serviceDao.selectAllService();
        request.setAttribute("services",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request,response);
    }
}
