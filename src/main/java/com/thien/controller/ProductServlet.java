package com.thien.controller;

import com.thien.dao.ProductDao;
import com.thien.dao.ServiceDao;
import com.thien.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID  = 1L;
    private ProductDao productDao;
    public void init(){
        productDao = new ProductDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                showCreateProduct(request,response);
                break;
            default:
                showListProduct(request,response);
                break;
        }
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productDao.selectAllProduct();
        request.setAttribute("products",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            request.setCharacterEncoding("utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

//        String action = request.getParameter("action");
//
//        if (action==null){
//            action="";
//        }
//
//        switch (action){
//            case "create":
//                try {
//                    createProduct(request,response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                break;
//        }
        String name = request.getParameter("name_product");
        System.out.println(name);
        double price = Double.parseDouble(request.getParameter("priceProduct"));
        String image = request.getParameter("image64");
        Product product = new Product(name,price,image);
        try {
            productDao.insertProduct(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request,response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("nameProduct");
        double price = Double.parseDouble(request.getParameter("priceProduct"));
        String image = request.getParameter("image64");
        Product product = new Product(name,price,image);
        productDao.insertProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request,response);
    }
}
