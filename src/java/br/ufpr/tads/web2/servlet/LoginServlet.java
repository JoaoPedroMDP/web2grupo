package br.ufpr.tads.web2.servlet;

import br.ufpr.tads.web2.bean.Login;
import br.ufpr.tads.web2.bean.User;
import br.ufpr.tads.web2.dao.UserDAO;
import br.ufpr.tads.web2.exception.DAOException;
import br.ufpr.tads.web2.util.ConnectionFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author LucasRC
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {    
    request.setCharacterEncoding("UTF-8");

    // Capturar credenciais de acesso
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    User user;
    UserDAO userDAO = new UserDAO(new ConnectionFactory().getConnection());
          
    // Validar se usuário está logado
    if (email != null && password != null) {
      if (request.getSession(false) != null) {
        response.sendRedirect("login.html");
        return;
      }
      
      if (userDAO.existLogin(email)) {
        user = userDAO.validationLogin(email, password);
        if (user != null) {
          Login loginBean = new Login();
          loginBean.setId(user.getId());
          loginBean.setName(user.getName());
          loginBean.setSurname(user.getSurname());
          loginBean.setEmail(user.getEmail());
          loginBean.setPassword(user.getPassword());
          loginBean.setCpf(user.getCpf());
          loginBean.setPhone(user.getPhone());
          loginBean.setRole(user.getRole());
          loginBean.setAddress_id(user.getAddress_id());
          
          HttpSession session = request.getSession();
          session.setAttribute("login", loginBean);
          
          switch (loginBean.getRole()) {
            case "customer":
              response.sendRedirect("customer/callList.jsp");
              break;
            case "employee":
              response.sendRedirect("employee/callListEmployee.jsp");
              break;
            case "admin":
              response.sendRedirect("admin/userList.jsp");
              break;
          }
        } else {
          // Em caso de erro, exibir view de erro
          request.setAttribute("msg", "Credenciais inválidas");
          request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
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
    try {
      processRequest(request, response);
    } catch (DAOException ex) {
      Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    } catch (DAOException ex) {
      Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
