/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets.ticket;

import beans.Ticket;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.DAOException;
import facades.TicketFacade;
import utils.frontHelpers.table.Table;

/**
 *
 * @author joao
 */
@WebServlet(name = "TicketServlet", urlPatterns = {"/TicketServlet"})
public class TicketServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = (String) request.getParameter("action");

            switch(action){
                case "listTickets":
                    this.listTickets(request, response);
                case "delete":
                    this.deleteTicket(request, response);
                case "edit" :
                    this.editTicket(request,response);
                case "update" :
                    this.updateTicket(request,response);
            }
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listTickets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
        TicketFacade ticketFacade = new TicketFacade();
        // Login loginBean = (Login) request.getSession().getAttribute("login");
        Table ticketTable = ticketFacade.listTickets("admin"); // TODO: trocar para o role do usuario logado
        request.setAttribute("table_items", ticketTable);
        RequestDispatcher rd = request.getRequestDispatcher("/customer/callList.jsp");
        rd.forward(request, response);
    }

    private void editTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
        TicketFacade ticketFacade = new TicketFacade();
        int i;
        int id = Integer.parseInt((String) request.getParameter("id"));
        Ticket ticket = ticketFacade.getTicket(id);  
        request.setAttribute("ticket", ticket);
        RequestDispatcher rd = request.getRequestDispatcher("/employee/callEdit.jsp");
        rd.forward(request, response);
    }

    private void updateTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
       TicketFacade ticketFacade = new TicketFacade();
       Ticket ticket = new Ticket();
       ticket.setDescription(((String)request.getParameter("description")));
       ticket.setId(Integer.parseInt((String)request.getParameter("id")));
       ticket.setProduct_id(Integer.parseInt((String) request.getParameter("product_id")));
       ticket.setSolution(((String)request.getParameter("solution")));
       ticket.setState(((String)request.getParameter("state")));
       ticket.setType_id(Integer.parseInt((String) request.getParameter("type_id")));
       ticket.setUser_id(Integer.parseInt((String) request.getParameter("user_id")));
       ticketFacade.updateTicket(ticket);
       request.setAttribute("ticket", ticket);
       RequestDispatcher rd = request.getRequestDispatcher("/employee/callEdit.jsp");
       rd.forward(request, response);
    }

    private void deleteTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
        TicketFacade ticketFacade = new TicketFacade();
        String id = (String) request.getParameter("id");
        ticketFacade.deleteTicket(id);
        this.listTickets(request, response);
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
