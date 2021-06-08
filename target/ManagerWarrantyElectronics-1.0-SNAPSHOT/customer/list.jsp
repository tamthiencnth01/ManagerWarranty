<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/5/2021
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Customer Manager</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <h1>List Customer</h1>--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Họ và tên</th>--%>
<%--            <th>Địa Chỉ</th>--%>
<%--            <th>Email</th>--%>
<%--            <th>Điện Thoại</th>--%>
<%--            <th>Thao Tác</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${customers}" var="customer">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${customer.id}"/></td>--%>
<%--                <td><c:out value="${customer.fullName}"/></td>--%>
<%--                <td><c:out value="${customer.address}"/></td>--%>
<%--                <td><c:out value="${customer.email}"/></td>--%>
<%--                <td><c:out value="${customer.phone}"/></td>--%>
<%--                <td>--%>
<%--                    <a href="/customers?action=edit&id=${customer.id}">Edit</a>--%>
<%--                    <a href="/customers?action=delete&id=${customer.id}">Delete</a>--%>
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
                        <h3>Khách Hàng<small>(tất cả thông tin chi tiết về khách hàng)</small></h3>
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

                <div class="col-md-6 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Khởi Tạo Khách Hàng <small></small></h2>
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
                            <br />
                            <c:if test="${check == null}">

                            <form action="customers?action=create" method="post" class="form-horizontal form-label-left input_mask">

                                <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                    <input type="text" name="name" class="form-control has-feedback-left" id="inputSuccess2" placeholder="Full Name">
                                    <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                </div>

                                <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                    <input type="text" name="address" class="form-control" id="inputSuccess3" placeholder="Address">
                                    <span class="fa fa-user form-control-feedback right" aria-hidden="true"></span>
                                </div>

                                <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                    <input type="text" name="email" class="form-control has-feedback-left" id="inputSuccess4" placeholder="Email">
                                    <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
                                </div>

                                <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                    <input type="text" name="phone" class="form-control" id="inputSuccess5" placeholder="Phone">
                                    <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên Dịch Vụ</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <select name="description" class="form-control">
                                            <c:forEach items="${services}" var="service">
                                                <option>${service.description}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Số Lượng</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <select name="quantities" class="form-control">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên Nhân Viên Thực Hiện</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <select name="nameEmp" class="form-control">
                                            <c:forEach items="${employees}" var="employee">
                                                <option>${employee.nameEmp}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="ln_solid"></div>
                                <div class="form-group">
                                    <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                        <button type="button" class="btn btn-primary">Cancel</button>
                                        <button class="btn btn-primary" type="reset">Reset</button>
                                        <button type="submit" class="btn btn-success">Submit</button>
                                    </div>
                                </div>
                            </form>
                            </c:if>
                            <c:if test="${check != null}">

                                <form action="customers?action=edit" method="post" class="form-horizontal form-label-left input_mask">
                                    <input type="hidden" name="id" value="${check.id}"/>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" name="name" class="form-control has-feedback-left" id="inputSuccess2" value="${check.fullName}">
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" name="address" class="form-control" id="inputSuccess3" value="${check.address}">
                                        <span class="fa fa-user form-control-feedback right" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" name="email" class="form-control has-feedback-left" id="inputSuccess4" value="${check.email}">
                                        <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="text" name="phone" class="form-control" id="inputSuccess5" value="${check.phone}">
                                        <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên Dịch Vụ</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <select name="description" class="form-control">
                                                <c:forEach items="${services}" var="service">
                                                    <option>${service.description}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Số Lượng</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <select name="quantities" class="form-control">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                                <option value="6">6</option>
                                                <option value="7">7</option>
                                                <option value="8">8</option>
                                                <option value="9">9</option>
                                                <option value="10">10</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên Nhân Viên Thực Hiện</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <select name="nameEmp" class="form-control">
                                                <c:forEach items="${employees}" var="employee">
                                                    <option>${employee.nameEmp}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                            <button type="button" class="btn btn-primary">Cancel</button>
                                            <button class="btn btn-primary" type="reset">Reset</button>
                                            <button type="submit" class="btn btn-warning">Edit</button>
                                        </div>
                                    </div>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </div>

                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Danh Sách Khách Hàng <small></small></h2>
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
                                Thông tin chi tiết của khách hàng
                            </p>
                            <table id="example" class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Full Name</th>
                                    <th>Address</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                    <th>Action</th>
                                </tr>
                                </thead>


                                <tbody>
                                    <c:forEach items="${customers}" var="customer">
                                        <tr>
                                            <td>
                                                <c:out value="${customer.id}"/>
                                            </td>
                                            <td>
                                                <c:out value="${customer.fullName}"/>
                                            </td>
                                            <td>
                                                <c:out value="${customer.address}"/>
                                            </td>
                                            <td>
                                                <c:out value="${customer.email}"/>
                                            </td>
                                            <td>
                                                <c:out value="${customer.phone}"/></td>
                                            <td>
                                                <a href="/customers?action=edit&id=${customer.id}">Edit</a>
                                                <a href="#" onclick="showMess(${customer.id})">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
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
            window.location.href ='/customers?action=delete&id='+ id;
        }
    }
    $(document).ready(function() {

        $('#example').dataTable({}); // dòng này để nhúng bảng biểu thành dạng bảng được phân trang

    } );
</script>
</body>
</html>