<%-- 
    Document   : View_products
    Created on : 25 thg 10, 2021, 09:55:15
    Author     : Nguyen Van Toan
--%>

<%@page import="Entity.Staff"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entity.Product"%>
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
                    <!--Xem sản phẩm-->
                <%  Staff sta = (Staff) session.getAttribute("staff");
                    if (sta != null && sta.getPosition().equals("manager")) {%>
                    <a href="/BTL_LTW/nextEditPage?controll=create" class="btn btn-success btn-lg">thêm sản phẩm</a>
                <%}%>
                    <div id="content" class="row">
                        <c:forEach items="${listP}" var="o">
                            <div class="product col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img" src="${o.image}" alt="Food image">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt">${o.name}</h4>
                                        <p class="card-text show_txt">${o.tittle}</p>
                                        <p >Danh mục: ${o.classify.tittle}</p>
                                        <p class="btn btn-danger">${o.price} VNĐ</p>
                                        <c:set var="pos" value="manager"/>
                                        <c:if test="${staff!=null && staff.position eq pos}">
                                        <p class="card-text show_txt">id: ${o.id}</p>
                                        <div class="row">
                                            <div class="col">
                                                <a href="/BTL_LTW/nextEditPage?id=${o.id}&controll=update" class="btn btn-success btn-block">Sửa</a>
                                                
                                            </div>
                                            <div class="col">
                                                <button onclick="deleteProd(${o.id})" class="btn btn-success btn-block"> Xoá</button>
                                            </div>
                                        </div>
                                        </c:if>
                                        
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        
        <jsp:include page="Footer.jsp"></jsp:include>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
        <script>
            function deleteProd(a) {
                var c= confirm("chắc chắn xoá sản phẩm có id="+a+" ?");
                if (c == true) {
                    var txt= "/BTL_LTW/EditProdsvl?id="+a+"&controll=remove";
                    window.location.href = txt;
                }
            }
//            function loadMore(){
//                var num= document.getElementsByClassName("product").length;
//                $.ajax({
//                    url: "/BTL_LTW/LoadMore",
//                    type: "get",
//                    data: {
//                        exits: num
//                    },
//                    success: function (data){
//                        var row= document.getElementById("content");
//                        row.innerHTML += data;
//                    },
//                    error: function (){
//                        alert("err")
//                    }
//                });
//            }
        </script>
    </body>
</html>
