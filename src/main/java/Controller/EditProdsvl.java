/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.HistoryUpdateDAO;
import DAO.ProductDAO;
import Entity.Classify;
import Entity.HistoryUpdate;
import Entity.Product;
import Entity.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nguyen Van Toan
 */
public class EditProdsvl extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String controll= request.getParameter("controll");
        ProductDAO dao= new ProductDAO();
        Product prod= new Product();
        HttpSession ses= request.getSession();
        Staff staff= (Staff) ses.getAttribute("staff");
        if(staff==null || !staff.getPosition().equals("manager")){
            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
        }else{
            if (controll.equalsIgnoreCase("remove")) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.remove(id);
                prod.setId(id);
            } else {
                prod = new Product(Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"),
                        Integer.parseInt(request.getParameter("price")),
                        request.getParameter("tittle"),
                        request.getParameter("image"),
                        new Classify(Integer.parseInt(request.getParameter("idC"))));
                if (controll.equalsIgnoreCase("update")) {
                    dao.edit(prod);
                } else if (controll.equalsIgnoreCase("create")) {
                    dao.add(prod);
                }
            }

            HistoryUpdate his = new HistoryUpdate(staff, prod, controll, controll);
            HistoryUpdateDAO hisDAO = new HistoryUpdateDAO();
            hisDAO.addHis(his);
            request.getRequestDispatcher("Homesvl").forward(request, response);
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
