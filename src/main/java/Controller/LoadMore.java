/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import Entity.Product;
import Entity.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nguyen Van Toan
 */
public class LoadMore extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session= request.getSession();
        Staff sta= (Staff) session.getAttribute("staff");
        int num= Integer.parseInt(request.getParameter("exits"));
        ProductDAO dao= new ProductDAO();
        List<Product> list= dao.getNext3(num);
        PrintWriter out= response.getWriter();
        for(Product i: list){
            out.println("<div class=\"product col-12 col-md-6 col-lg-4\">\n" +
"                                <div class=\"card\">\n" +
"                                    <img class=\"card-img\" src=\""+i.getImage()+"\" alt=\"Food image\">\n" +
"                                    <div class=\"card-body\">\n" +
"                                        <h4 class=\"card-title show_txt\">"+i.getName()+"</h4>\n" +
"                                        <p class=\"card-text show_txt\">"+i.getTittle()+"</p>\n" +
"                                        <p >Danh mục: "+i.getClassify().getTittle()+"</p>\n" +
"                                        <p class=\"btn btn-danger\">"+i.getPrice()+" VNĐ</p>\n" +
"                                        <c:set var=\"pos\" value=\"manager\"/>\n" +
"                                        <c:if test=\"${staff!=null && staff.position eq pos}\">" +
"                                        <div class=\"row\">\n" +
"                                            <div class=\"col\">\n" +
"                                                <a href=\"/BTL_LTW/nextEditPage?id="+i.getId()+"&controll=update\" class=\"btn btn-success btn-block\">Sửa</a>\n" +
"                                                \n" +
"                                            </div>\n" +
"                                            <div class=\"col\">\n" +
"                                                <a href=\"/BTL_LTW/EditProdsvl?id="+i.getId()+"&controll=remove\" class=\"btn btn-success btn-block\">Xoá</a>\n" +
"                                            </div>\n" +
"                                        </div>\n" +
"                                        </c:if>\n" +
"                                        \n" +
"                                    </div>\n" +
"                                </div>\n" +
"                            </div>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
