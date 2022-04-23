/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.Address;
import Beans.User;
import facade.AddressFacade;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import facade.UserFacade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 *
 * @author Ludimilla
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

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
       int id;
            User user;
            String action = request.getParameter("action");
            switch (action) {
                case "show": {
                    id = Integer.parseInt(request.getParameter("id"));
                    user = UserFacade.serchUser(id);
                    request.setAttribute("user", user);
                    Address addr = AddressFacade.serchAddress(user.getAddress_id());
                    request.setAttribute("address", addr);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/customer/profile.jsp");
                    rd.forward(request, response);
//                    request.getRequestDispatcher("/clientesVisualizar.jsp").forward(request, response);
                    break;
                }
                case "formUpdate":
                    id = Integer.parseInt(request.getParameter("id"));
                    user = UserFacade.serchUser(id);
                    request.setAttribute("cliente", user);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientesForm.jsp");
                    rd.forward(request, response);
                    break;
                case "remove":
                    id = Integer.parseInt(request.getParameter("id"));
                    UserFacade.DeleteUser(id);
                    request.getRequestDispatcher("/ClientesServlet?action=list").forward(request, response);
                    break;
                case "formNew":
                     RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/clientesForm.jsp");
                    request.setAttribute("action", "new");
                    rd2.forward(request, response);
                    break;
                case "new":
                   Address newAddress = new Address(request.getParameter("street"), request.getParameter("number"), request.getParameter("complement"),request.getParameter("district"), Integer.parseInt(request.getParameter("zip_code")));
                   AddressFacade.CreateAddress(newAddress);
                   Address gotAdress = AddressFacade.serchAddressByZipCode(Integer.parseInt(request.getParameter("zip_code")));
                   int addressId = gotAdress.getId();
                   User newUser = new User(request.getParameter("name"), request.getParameter("surname"), request.getParameter("email"),request.getParameter("password"), request.getParameter("cpf"), request.getParameter("phone"), addressId);
                   UserFacade.CreateUser(newUser);
                    RequestDispatcher rdNew = getServletContext().getRequestDispatcher("/login.html");
                    rdNew.forward(request, response);
                    break;

                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                        User update = new User(request.getParameter("name"), request.getParameter("surname"), request.getParameter("email"),request.getParameter("password"), request.getParameter("cpf"), request.getParameter("phone"));
                        UserFacade.UpdateUser(id, update);
                    RequestDispatcher rdUpdate = getServletContext().getRequestDispatcher("/ClientesServlet?action=list");
                    rdUpdate.forward(request, response);
                    break;
                default: {
                  
                    break;
                }

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
