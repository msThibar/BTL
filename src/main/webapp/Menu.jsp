<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entity.Staff"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="Home.jsp">Bếp Việt</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/BTL_LTW/Homesvl">Home</a>
                </li>
                
                <c:if test="${staff!=null}">
                    <li class="nav-item">
                        <p class="nav-link" href="#">Hello ${staff.username}</p>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="/BTL_LTW/Logout">Logout</a></li>
                </c:if>
                <c:if test="${staff==null}">
                    <li class="nav-item"><a class="nav-link" href="/BTL_LTW/index.html">Login</a></li>
                </c:if>
            </ul>

            <form action="searchPro" method="get" class="form-inline my-2 my-lg-0" accept-charset="utf-8">
                <div class="input-group input-group-sm">
                    <input name="txt" type="text" value="${txtS}" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Bếp Việt</h1>
        <p class="lead text-muted mb-0">Tinh tuý nghìn năm ẩm thực Việt</p>
    </div>
</section>
<!--end of menu-->