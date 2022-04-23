/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Interfaces.Tests;
import Tests.TestAddress;
import Tests.TestCategory;
import Tests.TestCity;
import Tests.TestProduct;
import Tests.TestState;
import Tests.TestTicket;
import Tests.TestType;
import Tests.TestUser;
import jakarta.servlet.annotation.WebServlet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joao
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    private void testUser(PrintWriter out) throws Exception {
        try {
            TestUser test = new TestUser();
            test.testInsertion();
            test.testGet();
            test.testIndex();
            test.testDeletion();
            test.testUpdate();
        } catch (Exception e) {
            out.println("<p>Erro USER: " + e.getMessage() + "</p>");
            throw e;
        }
    }

    private void testAddress(PrintWriter out) throws Exception {
        try {
            TestAddress test = new TestAddress();
            test.testInsertion();
            test.testGet();
            test.testIndex();
            test.testDeletion();
            test.testUpdate();
        } catch (Exception e) {
            out.println("<p>Erro ADDRESS: " + e.getMessage() + "</p>");
            throw e;
        }
    }

    private void testCategory(PrintWriter out) throws Exception {
        try {
            TestCategory test = new TestCategory();
            test.testInsertion();
            test.testGet();
            test.testIndex();
            test.testDeletion();
            test.testUpdate();
        } catch (Exception e) {
            out.println("<p>Erro CATEGORY: " + e.getMessage() + "</p>");
            throw e;
        }
    }

    private void testType(PrintWriter out) throws Exception {
        try {
            TestType test = new TestType();
            test.testInsertion();
            test.testGet();
            test.testIndex();
            test.testDeletion();
            test.testUpdate();
        } catch (Exception e) {
            out.println("<p>Erro TYPE: " + e.getMessage() + "</p>");
            throw e;
        }
    }

    private void testProduct(PrintWriter out) throws Exception {
        try {
            TestProduct test = new TestProduct();
            test.testInsertion();
            test.testGet();
            test.testIndex();
            test.testDeletion();
            test.testUpdate();
        } catch (Exception e) {
            out.println("<p>Erro PRODUCT: " + e.getMessage() + "</p>");
            throw e;
        }
    }

    private void testTicket(PrintWriter out) throws Exception {
        try {
            TestTicket test = new TestTicket();
            test.testInsertion();
            test.testGet();
            test.testIndex();
            test.testDeletion();
            test.testUpdate();
        } catch (Exception e) {
            out.println("<p>Erro TICKET: " + e.getMessage() + "</p>");
            throw e;
        }
    }

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Testando</h1>");

            this.testType(out);
            this.testCategory(out);
            this.testProduct(out);
            this.testAddress(out);
            this.testUser(out);
            this.testTicket(out);

            out.println("</body>");
            out.println("</html>");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
