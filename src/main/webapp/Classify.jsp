<%-- 
    Document   : Classify
    Created on : 30 thg 10, 2021, 17:09:52
    Author     : Nguyen Van Toan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entity.Staff"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--Danh mục sản phẩm-->
<div class="card bg-light mb-3">
    <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
    <ul class="list-group category_block">
        <li class="list-group-item text-white">
                <a href="http://localhost:8080/BTL_LTW/Homesvl">tất cả</a>
        </li>
        <c:forEach items="${listC}" var="o">
            <li class="list-group-item text-white">
                <a href="http://localhost:8080/BTL_LTW/getByClassifysvl?id=${o.id}">${o.tittle}</a>
            </li>

        </c:forEach>
    </ul>
</div>