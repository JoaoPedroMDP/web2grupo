/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import beans.Address;
import beans.City;
import beans.State;
import beans.User;
import exceptions.DAOException;
import facade.AddressFacade;
import facade.CityFacade;
import facade.StateFacade;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import validators.UserValidator;

/**
 *
 * @author Ludimilla
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

      List<State> stateList = new ArrayList<>();
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
        User user = null;
        Address gotAdress = null;
        Address addr = null;
        City getCityId = null;
        String action = request.getParameter("action");
        switch (action) {
            case "show": {
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    user = UserFacade.serchUser(id);
                } catch (DAOException ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("user", user);
                try {
                    addr = AddressFacade.serchAddress(user.getAddress_id());
                } catch (DAOException ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("address", addr);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/customer/profile.jsp");
                rd.forward(request, response);
                break;
            }
            case "formUpdate":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    user = UserFacade.serchUser(id);
                } catch (DAOException ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("user", user);

                try {
                    addr = AddressFacade.serchAddress(user.getAddress_id());
                } catch (DAOException ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("address", addr);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/customer/register.jsp");
                request.setAttribute("action", "update");
                rd.forward(request, response);
                break;
            case "formNew":
                
                RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/customer/register.jsp");
                StateFacade s = new StateFacade();
                {
                    try {
                        stateList = s.searchList();
                    } catch (DAOException ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                request.setAttribute("states", stateList);
                request.setAttribute("action", "new");
                rd2.forward(request, response);
                break;
                
               
            case "new":

                   try {
                        getCityId = CityFacade.serchCityId(request.getParameter("city"));
                    } catch (DAOException ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    int cityId = getCityId.getId();
                    Address newAddress = new Address(request.getParameter("street"), request.getParameter("number"), request.getParameter("complement"), request.getParameter("district"), Integer.parseInt(request.getParameter("zip_code")), cityId);
                    try {
                        AddressFacade.CreateAddress(newAddress);
                    } catch (DAOException ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        gotAdress = AddressFacade.serchAddressByZipCode(Integer.parseInt(request.getParameter("zip_code")), request.getParameter("number"));
                    } catch (DAOException ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    int addressId = gotAdress.getId();
                    User newUser = new User(request.getParameter("name"), request.getParameter("surname"), request.getParameter("email"), request.getParameter("password"), request.getParameter("cpf"), request.getParameter("phone"), addressId);
                    try {
                        UserFacade.CreateUser(newUser);
                    } catch (DAOException ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
       

                    RequestDispatcher rdNew = getServletContext().getRequestDispatcher("/login.html");
                    rdNew.forward(request, response);
                    break;
    

                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                    System.out.println("Update id:"+ id);
                        User update = new User(request.getParameter("name"), request.getParameter("surname"),request.getParameter("password"), request.getParameter("phone"));
                        try {
                        UserFacade.UpdateUser(id, update);
                          } catch (DAOException ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                    RequestDispatcher rdUpdate = getServletContext().getRequestDispatcher("/UserServlet?action=show&id=12");
                    rdUpdate.forward(request, response);
                    break;
                default: {
                    
                    RequestDispatcher erro = getServletContext().getRequestDispatcher("/erro.jsp");
                request.setAttribute("erro","Usuário deve se autenticar para acessar o sistema.");
                request.setAttribute("link", "login.html");
                erro.forward(request, response);
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
