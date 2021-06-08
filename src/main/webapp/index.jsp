<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<center><h1><%= "Quản Lý Nhân Viên" %>--%>
<%--</h1>--%>
<%--    <p>--%>
<%--        <c:if test='${requestScope["message"] != null}'>--%>
<%--            <span class="message">${requestScope["message"]}</span>--%>
<%--        </c:if>--%>
<%--    </p></center>--%>
<%--<div align="center">--%>
<%--    <form action="account" method="post">--%>
<%--        <input type="hidden" name="action" value="login"/>--%>
<%--        <h4>Tài khoản: </h4>--%>
<%--        <input type="text" name="username" placeholder="Input Username"/>--%>
<%--        <h4>Mật khẩu: </h4>--%>
<%--        <input type="password" name="password" placeholder="Input Password"/>--%>
<%--        <br>--%>
<%--        <br>--%>
<%--        <input type="submit" value="Log In"/>--%>
<%--        <a href="/account?action=create">SingUp</a>--%>
<%--    </form>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Manager Services </title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="../vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="account" method="post">
                    <input type="hidden" name="action" value="login"/>
<%--                    <input type="hidden" name="action" value="suscess"/>--%>
                    <h1>Login Form</h1>
                    <div>
                        <input type="text" name="username" class="form-control" placeholder="Username" required="" />
                    </div>
                    <div>
                        <input type="password" name="password" class="form-control" placeholder="Password" required="" />
                    </div>
                    <div>
                        <input class="btn btn-default submit" type="submit" value="Log In"/>
                                <c:if test='${requestScope["message"] != null}'>
                                    <span class="badge badge-pill badge-danger">${requestScope["message"]}</span>
                                </c:if>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">New to site?
                            <a href="#signup" class="to_register"> Create Account </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                        <div>
                            <h1><i class="fa fa-paw"></i> Tâm Thiện Company</h1>
                            <p>Established In 2003</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>

        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form method="post" action="account">
                    <input type="hidden" name="action" value="create"/>
                    <h1>Create Account</h1>
                    <div>
                        <input type="text" name="user" class="form-control" placeholder="Username" required="" />
                    </div>
                    <div>
                        <input type="email" name="email" class="form-control" placeholder="Email" required="" />
                    </div>
                    <div>
                        <input type="password" name="password" class="form-control" placeholder="Password" required="" />
                    </div>
                    <div>
                        <input type="password" name="repassword" class="form-control" placeholder="Confirm Password" required="" />
                    </div>
                    <div>
                        <input class="btn btn-default submit" type="submit" value="Submit"/>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">Already a member ?
                            <a href="#signin" class="to_register"> Log in </a>
                        </p>

                        <div class="clearfix"></div>
                        <br />

                        <div>
                            <h1><i class="fa fa-paw"></i> Tâm Thiện Company</h1>
                            <p>Established In 2003</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>
