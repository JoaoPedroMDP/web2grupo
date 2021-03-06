/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets.admin;

import exceptions.DAOException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import utils.ConnectionFactory;

/**
 *
 * @author joao
 */
@WebServlet(name = "ReportsServlet", urlPatterns = {"/ReportsServlet"})
public class ReportsServlet extends HttpServlet {
    private HashMap<String, String> availableReports;

    public void init(){
        this.availableReports = new HashMap<String, String>(){{
            put("employee", "Employee");
            put("tickets", "Tickets");
            put("products", "Products");
        }};
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String report = (String) request.getParameter("report");
        Connection conn = null;
        try {
            conn = new ConnectionFactory().getConnection();
        } catch (DAOException ex) {
            Logger.getLogger(ReportsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String host = "http://" + request.getServerName() + ":" + request.getServerPort();

        String jasperReportName = this.availableReports.get(report);

        if(jasperReportName != null){
            String jasper = request.getContextPath() + "/admin/reports/" + jasperReportName + ".jasper";
            String today = new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
            URL jasperURL = new URL(host + jasper);
            HashMap<String, Object> params = new HashMap<String, Object>(){{
                put("today", today);
            }};

            if(report.equals("tickets")){
                System.out.println("OI"+request.getParameter("from_date"));
                System.out.println("OI"+request.getParameter("to_date"));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                Date fromDate = sdf.parse(request.getParameter("from_date"));
                Date toDate = sdf.parse(request.getParameter("to_date"));

                java.sql.Timestamp from = new java.sql.Timestamp(fromDate.getTime());
                java.sql.Timestamp to = new java.sql.Timestamp(toDate.getTime());

                params.put("from_date", from);
                params.put("to_date", to);
            }

            byte[] bytes = null;
            try {
                // System.out.println(params.toString());
                bytes = JasperRunManager.runReportToPdf(
                        jasperURL.openStream(),
                        params,
                        conn);
            } catch (JRException ex) {
                Logger.getLogger(ReportsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (bytes != null) {
                response.setContentType("application/pdf");
                OutputStream ops = response.getOutputStream();
                ops.write(bytes);
            }
        }else{
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
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
