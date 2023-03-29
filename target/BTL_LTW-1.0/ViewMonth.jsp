<%-- 
    Document   : ViewMonth
    Created on : 2 thg 11, 2021, 16:26:47
    Author     : Nguyen Van Toan
--%>
<%@page import="Entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bếp Việt</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <jsp:include page="Classify.jsp"></jsp:include>
                    <jsp:include page="Statis.jsp"></jsp:include>
                </div>
                <div class="col-sm-9">
                <%  Staff sta = (Staff) session.getAttribute("staff");
                    if (sta == null || !sta.getPosition().equals("manager")) {%>
                    <jsp:include page="warning.jsp"></jsp:include>
                <%}else{%>
                    <!--Xem thống kê-->
                    <div class="alert alert-light">
                        <strong>thống kê tháng: ${month}</strong>
                    </div>
                    <table class="table table-bordered table-dark">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>số lượng</th>
                                <th>giá</th>
                                <th>Thành tiền</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listBL}" var="o">
                            <tr>
                                <td>${o.product.id}</td>
                                <td>${o.amount} </td>
                                <td>${o.price} </td>
                                <td>${o.amount*o.price}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                <%}%>

                </div>
            </div>
        </div>
        
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>
