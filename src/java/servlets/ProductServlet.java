/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Category;
import beans.Product;
import exceptions.DAOException;
import facades.CategoryFacade;
import facades.ProductFacade;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Leo
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    List<Product> productList = new ArrayList<>();

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
            throws ServletException, IOException, DAOException, ParseException, SQLException, NoSuchAlgorithmException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        switch (action) {
            case "list":
                ProductFacade clist = new ProductFacade();
                request.setAttribute("table_items", clist.buscarTodos("admin"));
                RequestDispatcher rdList = getServletContext().getRequestDispatcher("/employee/productList.jsp");
                rdList.forward(request, response);
                break;
            case "edit":
                String idForm = request.getParameter("id");
                ProductFacade cForm = new ProductFacade();
                Product changes = cForm.buscar(idForm);
                request.setAttribute("changes", changes);
                String idUpdate = request.getParameter("id");
                request.setAttribute("idUpdate", idUpdate);
                int catedit = changes.getId();
                String catedits = catedit+"";
                CategoryFacade categoryF = new CategoryFacade();
                Category ctgedit = categoryF.buscar(catedits);
                request.setAttribute("category", ctgedit);
                RequestDispatcher rdFUpdate = getServletContext().getRequestDispatcher("/employee/product.jsp?action=update");
                request.setAttribute("action", "update");
                rdFUpdate.forward(request, response);
                break;
            case "delete":
                String idRemove = request.getParameter("id");
                ProductFacade cRemove = new ProductFacade();
                Product remove = cRemove.buscar(idRemove);
                cRemove.remover(remove);
                RequestDispatcher rdRemove = getServletContext().getRequestDispatcher("/ProductServlet?action=list");
                request.setAttribute("msg", "Removido com sucesso");
                rdRemove.forward(request, response);
                break;
            case "update":
                float weight = Float.parseFloat(request.getParameter("weight"));
                String img = request.getParameter("img");
                String nome = request.getParameter("name");
                String updateId = request.getParameter("id");
                String cat = request.getParameter("category_id");
                CategoryFacade cf = new CategoryFacade();
                Category ctg = cf.buscar(cat);
                int category_id = ctg.getId();
                int id = Integer.parseInt(updateId);
                Product prod = new Product(id, nome, img, weight, category_id);
                ProductFacade cUpdate = new ProductFacade();
                cUpdate.alterar(prod);
                RequestDispatcher rdUpdate = getServletContext().getRequestDispatcher("/ProductServlet?action=list");
                rdUpdate.forward(request, response);
                break;
            case "formNew":
                request.setAttribute("action", "new");
                RequestDispatcher rdForm = getServletContext().getRequestDispatcher("/employee/product.jsp?action=new");
                rdForm.forward(request, response);
                break;
            case "new":
                float weightnew = Float.parseFloat(request.getParameter("weight"));
                String imgnew = request.getParameter("img");
                String nomeNew = request.getParameter("name");
                String catnew = request.getParameter("category");  
                ProductFacade c = new ProductFacade();   
                CategoryFacade cfd = new CategoryFacade();
                Category ctgnew = cfd.buscar(catnew);
                List<Product> compare = c.buscarUm(nomeNew);
                if (nomeNew == null ? compare.get(0) != null : !nomeNew.equals(compare.get(0))) {
                    Product prodn = new Product(nomeNew,imgnew,weightnew,ctgnew.getId());
                    c.inserir(prodn);
                    request.setAttribute("msg", "Inserido com Sucesso");
                    RequestDispatcher rdNew = getServletContext().getRequestDispatcher("/ProductServlet?action=list");
                    rdNew.forward(request, response);
                } else {
                    RequestDispatcher rdNew = getServletContext().getRequestDispatcher("/ProductServlet?action=list");
                    request.setAttribute("msg", "Erro");
                    rdNew.forward(request, response);
                }

                break;
            default:
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/ProductServlet?action=list");
                request.setAttribute("msg", "Ação inexistente");
                request.setAttribute("page", "ProductServlet?action=list");
                rd.forward(request, response);
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
        } catch (ParseException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
