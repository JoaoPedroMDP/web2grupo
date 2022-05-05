/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Category;
import exceptions.DAOException;
import facades.CategoryFacade;
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
@WebServlet(name = "CategoryServlet", urlPatterns = {"/CategoryServlet"})
public class CategoryServlet extends HttpServlet {

    List<Category> CategoryList = new ArrayList<>();

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
                CategoryFacade clist = new CategoryFacade();
                request.setAttribute("table_items", clist.buscarTodos("admin"));
                RequestDispatcher rdList = getServletContext().getRequestDispatcher("/employee/categoryList.jsp");
                rdList.forward(request, response);
                break;
            case "edit":
                String idForm = request.getParameter("id");
                CategoryFacade cForm = new CategoryFacade();
                Category changes = cForm.buscar(idForm);
                request.setAttribute("changes", changes);
                String idUpdate = request.getParameter("id");
                request.setAttribute("idUpdate", idUpdate);
                RequestDispatcher rdFUpdate = getServletContext().getRequestDispatcher("/employee/category.jsp?action=update");
                request.setAttribute("action", "update");
                rdFUpdate.forward(request, response);
                break;
            case "delete":
                String idRemove = request.getParameter("id");
                CategoryFacade cRemove = new CategoryFacade();
                Category remove = cRemove.buscar(idRemove);
                cRemove.remover(remove);
                RequestDispatcher rdRemove = getServletContext().getRequestDispatcher("/CategoryServlet?action=list");
                request.setAttribute("msg", "Removido com sucesso");
                rdRemove.forward(request, response);
                break;
            case "update":
                String nome = request.getParameter("name");
                String updateId = request.getParameter("id");
                int id = Integer.parseInt(updateId);
                Category ctg = new Category(id, nome);
                CategoryFacade cUpdate = new CategoryFacade();
                cUpdate.alterar(ctg);
                RequestDispatcher rdUpdate = getServletContext().getRequestDispatcher("/CategoryServlet?action=list");
                rdUpdate.forward(request, response);
                break;
            case "formNew":
                request.setAttribute("action", "new");
                RequestDispatcher rdForm = getServletContext().getRequestDispatcher("/employee/category.jsp?action=new");
                rdForm.forward(request, response);
                break;
            case "new":
                String nomeNew = request.getParameter("name");
                CategoryFacade c = new CategoryFacade();
                Category compare = c.buscar(nomeNew);
                if (nomeNew == null ? compare.getName() != null : !nomeNew.equals(compare.getName())) {
                    Category ct = new Category(nomeNew);
                    c.inserir(ct);
                    request.setAttribute("msg", "Inserido com Sucesso");
                    RequestDispatcher rdNew = getServletContext().getRequestDispatcher("/CategoryServlet?action=list");
                    rdNew.forward(request, response);
                } else {
                    RequestDispatcher rdNew = getServletContext().getRequestDispatcher("/CategoryServlet?action=list");
                    request.setAttribute("msg", "Erro");
                    rdNew.forward(request, response);
                }

                break;
            default:
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/CategoryServlet?action=list");
                request.setAttribute("msg", "Ação inexistente");
                request.setAttribute("page", "CategoryServlet?action=list");
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
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
