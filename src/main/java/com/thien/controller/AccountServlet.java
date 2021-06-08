package com.thien.controller;

import com.thien.dao.AccountDao;
import com.thien.model.Account;
import com.thien.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AccountServlet", urlPatterns = "/account")
public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDao accountDao;
    public void init(){
        accountDao = new AccountDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "create":
                try {
                    showCreateForm(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                break;
            case "suscess":
                try {
                    showSuscessForm(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showLoginForm(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                break;
            }
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "login":
                try {
                    showLoginForm(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                break;
            case "create":
                try {
                    createAccount(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "suscess":
                try {
                    showSuscessForm(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void createAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("password");
        String repass = request.getParameter("repassword");
        String email = request.getParameter("email");
        List<Customer> list = accountDao.selectAllAccount();
        RequestDispatcher dispatcher;
        if (!pass.equals(repass)){
            response.sendRedirect("/index.jsp");
        }else{
            Account existAcc = accountDao.selectExistAccount(user);
            if (existAcc==null){
                Account account = new Account(user,pass,email);
                accountDao.insertAccount(account);
                request.setAttribute("listAcc",list);
                dispatcher = request.getRequestDispatcher("account/login.jsp");
                dispatcher.forward(request,response);
            }else{
                response.sendRedirect("/index.jsp");
            }
        }
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        Account existingAcc = accountDao.selectAccount(user,pass);
        List<Customer> list = accountDao.selectAllAccount();
        RequestDispatcher dispatcher;
        if (existingAcc==null){
            request.setAttribute("message", "Please Input Profile!");
            dispatcher = request.getRequestDispatcher("/index.jsp");
        }else {
            request.setAttribute("accounts",existingAcc);
            request.setAttribute("listAcc",list);
            dispatcher = request.getRequestDispatcher("account/login.jsp");
        }
        dispatcher.forward(request,response);
    }
    private void showSuscessForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        List<Customer> list = accountDao.selectAllAccount();
        Account existingAcc = accountDao.selectAccount(user,pass);
        request.setAttribute("listAcc",list);
        request.setAttribute("accounts",existingAcc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("account/login.jsp");
        dispatcher.forward(request,response);
    }
}
