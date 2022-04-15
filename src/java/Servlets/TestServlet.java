/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interfaces.Tests;
import Tests.TestAddress;
import Tests.TestCategory;
import Tests.TestCity;
import Tests.TestProduct;
import Tests.TestState;
import Tests.TestTicket;
import Tests.TestType;
import Tests.TestUser;

/**
 *
 * @author joao
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    private void test(PrintWriter out, Tests testSubject, String subject) throws Exception{
        try{
            testSubject.testInsertion();
            testSubject.testGet();
            testSubject.testIndex();
            testSubject.testDeletion();
            testSubject.testUpdate();
        }catch(Exception e){
            out.println("<p>Erro " + subject + ": " + e.getMessage() + "</p>");
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
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Testando</h1>");

            TestType testType = new TestType();
            this.test(out, testType, "Type");
            TestCategory testCategory = new TestCategory();
            this.test(out, testCategory, "Category");
            TestProduct testProduct = new TestProduct();
            this.test(out, testProduct, "Product");
            TestState testState = new TestState();
            this.test(out, testState, "State");
            TestCity testCity = new TestCity();
            this.test(out, testCity, "City");
            TestAddress testAddress = new TestAddress();
            this.test(out, testAddress, "Address");
            TestUser testUser = new TestUser();
            this.test(out, testUser, "User");
            TestTicket testTicket = new TestTicket();
            this.test(out, testTicket, "Ticket");
            
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
