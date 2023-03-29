<%-- 
    Document   : EditProduct
    Created on : 29 thg 10, 2021, 10:04:15
    Author     : Nguyen Van Toan
--%>

<%@page import="Entity.Staff"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:if test="${controll == 'update'}">
        <title>cập nhật sản phẩm</title>
    </c:if>
    <c:if test="${controll != 'update'}">
        <title>thêm sản phẩm</title>
    </c:if>
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
                    <div class="col-sm-2"></div>
                    <div class="col-sm-8">
                        
                        <form action="EditProdsvl" method="post" class="was-validated">
                            <input type="hidden" name="controll" value="${controll}">
                        <div class="form-group">
                            <label for="id">Id: </label>
                            <input type="text" class="form-control" value="${prod.id}" id="id" name="id" readonly>
                        </div>
                        <div class="form-group">
                            <label for="name">Tên sản phẩm: </label>
                            <input type="text" class="form-control" value="${prod.name}" id="name" name="name" required>
                            <div class="valid-feedback"></div>
                            <div class="invalid-feedback">*nhập để tiếp tục</div>
                        </div>
                        <div class="form-group">
                            <label for="price" >Giá sản phẩm: </label>
                            <input type="number" class="form-control" value="${prod.price}" id="price" name="price" required>
                            <div class="valid-feedback"></div>
                            <div class="invalid-feedback">*nhập để tiếp tục</div>
                        </div>
                        <div class="form-group">
                            <label for="title">Mô tả: </label>
                            <input type="text" class="form-control" value="${prod.tittle}" id="title" name="tittle" required>
                            <div class="valid-feedback"></div>
                            <div class="invalid-feedback">*nhập để tiếp tục</div>
                        </div>
                        <div class="form-group">
                            <label for="image">Image link: </label>
                            <input type="text" class="form-control" value="${prod.image}" id="image" name="image" required>
                            <div class="valid-feedback"></div>
                            <div class="invalid-feedback">*nhập để tiếp tục</div>
                        </div>
                        <div class="form-group">
                            <label for="cla">Danh mục sản phẩm</label>
                            <select id="cla" name="idC" required>
                                <c:forEach items="${listC}" var="o">
                                    <option value="${o.id}" <c:if test="${o.id == prod.classify.id}">selected</c:if>>${o.tittle}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="row">
                            <div class="col">
                                <input type="reset" class="btn btn-primary" value="reset">
                            </div>
                            <div class="col">
                                <input type="submit" class="btn btn-primary" value="Xác nhận">
                            </div>
                        </div>
                        
                    </form>
                </div>

                <div class="col-sm-2"></div>
            <%}%>
            </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>
