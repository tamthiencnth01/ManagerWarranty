<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Admin--%>
<%--  Date: 1/6/2021--%>
<%--  Time: 2:09 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Service Manager</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <h1>List Service</h1>--%>

<%--    <div align="center">--%>
<%--        <form method="post">--%>
<%--            <input type="hidden" name="action" value="create"/>--%>
<%--            <table border="1" cellpadding="5">--%>
<%--                <caption>--%>
<%--                    <h2>Create New Service</h2>--%>
<%--                </caption>--%>
<%--                <tr>--%>
<%--                    <th>Mã Dịch Vụ</th>--%>
<%--                    <td>--%>
<%--                        <input type="number" name="id" id="id" size="45"/>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Mô tả</th>--%>
<%--                    <td>--%>
<%--                        <input type="text" name="description" id="description" size="45"/>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Đơn Vị tính</th>--%>
<%--                    <td>--%>
<%--                        <input type="text" name="unit" id="unit" size="45"/>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Số Lượng</th>--%>
<%--                    <td>--%>
<%--                        <input type="number" name="quantities" id="quantities" size="45"/>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th>Đơn giá </th>--%>
<%--                    <td>--%>
<%--                        <input type="text" name="unitPrice" id="unitPrice" size="45"/>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td colspan="2" align="center">--%>
<%--                        <input type="submit" value="Create"/>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </table>--%>
<%--        </form>--%>
<%--    </div>--%>


<%--    <table>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Mô tả</th>--%>
<%--            <th>Đơn vị tính</th>--%>
<%--            <th>Số Lượng</th>--%>
<%--            <th>Đơn Giá</th>--%>
<%--            <th>Tổng Cộng</th>--%>
<%--            <th>Thao Tác</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${services}" var="service">--%>
<%--            <tr>--%>
<%--                <td>${service.getId()}</td>--%>
<%--                <td>${service.getDescription()}</td>--%>
<%--                <td>${service.getUnits()}</td>--%>
<%--                <td>${service.getQuantities()}</td>--%>
<%--                <td>${service.getUnitPrice()}</td>--%>
<%--                <td>${service.getAmount()}</td>--%>
<%--                <td>--%>
<%--                    <a href="/services?action=edit&id=${service.id}">Edit</a>--%>
<%--                    <a href="/services?action=delete&id=${service.id}">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</body>--%>
<%--</html>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Homepages Tâm Thiện Company</title>

    <%@ include file="/layout/head.jsp"%>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <%@include file="/layout/toggle.jsp"%>
        <!-- top navigation -->
        <%@include file="/layout/topnav.jsp"%>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Quản Lý Sản Phẩm<small></small></h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                            <form class="input-group" method="get">
                                <input type="hidden" name="action" value="search">
                                <input type="text" name="keyWord" class="form-control" placeholder="Search for...">
                                <span class="input-group-btn">
                                <input class="btn btn-default" type="submit">Go!</input>
                                </span>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>


                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Danh sách Sản Phẩm <small></small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Settings 1</a>
                                        </li>
                                        <li><a href="#">Settings 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <p class="text-muted font-13 m-b-30">
                                Tất cả thông tin về sản phẩm
                            </p>
                            <div class="col-md-12">
                                <c:forEach items="${products}" var="product">
                                    <div class="col-md-4 col-sm-4">

                                        <div class="store-item">
                                        <div class="store-item-rating text-warning">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star-half-o"></i>
                                        </div>
                                        <div class="store-item-image">
                                            <a href="#">
                                                <img src="${product.image}" alt="" class="img-responsive" style="max-width: 350px; max-height: 200px">
                                            </a>
                                        </div>
                                        <div class="store-item-info clearfix">
                                            <span class="store-item-price themed-color-dark pull-right">${product.price}</span>
                                            <a href="#"><strong>${product.nameProduct}</strong></a><br>
                                            <small><i class="fa fa-shopping-cart text-muted"></i>
                                                <a href="#" class="text-muted">Add to cart</a></small>
                                        </div>
                                    </div>

                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- /page content -->

    <!-- footer content -->
    <footer>
        <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
        </div>
        <div class="clearfix"></div>
    </footer>
    <!-- /footer content -->
</div>
</div>

<%@ include file="/layout/script.jsp"%>
<script>
    function showMess(id){
        var option = confirm('are you sure to delete');
        if (option===true){
            window.location.href ='/services?action=delete&id='+ id;
        }
    }
    $(document).ready(function() {

        $('#example').dataTable({}); // dòng này để nhúng bảng biểu thành dạng bảng được phân trang

    } );
</script>
<script src="../vendors/jQuery-Smart-Wizard/js/jquery.smartWizard.js"></script>
</body>
</html>