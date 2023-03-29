<%-- 
    Document   : Statis
    Created on : 30 thg 10, 2021, 17:13:33
    Author     : Nguyen Van Toan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entity.Staff"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--Chức năng thống kê-->
<%  Staff sta=(Staff) session.getAttribute("staff");
    if(sta!=null && sta.getPosition().equals("manager")){%>
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Thống kê</div>
        <ul class="list-group category_block">
            <li class="list-group-item text-white">
                <a href="StatisMonth">Thống kê doanh thu theo tháng</a>
            </li>
            <li class="list-group-item text-white">
                <a href="StatisProd">Thống kê doanh thu theo tên sản phẩm</a>
            </li>
        </ul>
        <a href="Home.jsp"></a>
    </div>
<%}%>