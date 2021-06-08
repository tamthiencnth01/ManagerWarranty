<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="account?action=suscess" class="site_title"><i class="fa fa-paw"></i> <span>TT Company</span></a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile clearfix">
            <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
                <span>Welcome,</span>
                    <h2>${accounts.user}</h2>
            </div>
        </div>
        <!-- /menu profile quick info -->

        <br />

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-home"></i> Trang Chủ <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="account?action=suscess">Tổng Hợp</a></li>
                            <li><a href="customers">Khách Hàng</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-edit"></i> Quản Lý <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="services">Dịch Vụ</a></li>
                            <li><a href="employees">Nhân Viên</a></li>
                            <li><a href="products?action=create">Sản Phẩm</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-desktop"></i> Sản Phẩm <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="products">Computer</a></li>
                            <li><a href="media_gallery.html">Laptop</a></li>
                            <li><a href="typography.html">Máy In</a></li>
                            <li><a href="icons.html">Macbook</a></li>
                            <li><a href="glyphicons.html">AppleWatch</a></li>
                            <li><a href="widgets.html">Playstation</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Logout" href="/index.jsp">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>