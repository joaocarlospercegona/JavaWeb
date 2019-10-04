/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.LoginBean;
import Beans.Usuario;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joao
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String usuario = (String) request.getParameter("usuario");
        String senha = (String) request.getParameter("senha");
        String msg= "Usuario nao encontrado";
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        int i;
        
        try  {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> lista = dao.buscarTodos();
            for (Usuario x: lista) {
                out.println(x);
                if(usuario.equals(x.getUsuario())&&(senha.equals(x.getSenha()))){
                    out.println("logado:");
                    LoginBean p = new LoginBean();
                    p.setId(x.getId());
                    p.setNome(x.getNome());
                    String logado = p.toString(); 
                    session.setAttribute("logado",p);
                    session.setAttribute("logados",p);
                    RequestDispatcher rd = getServletContext().
            getRequestDispatcher("/Portal.jsp");
            rd.forward(request, response);
                }  
            }
         
            out.println("Deslogado");
                    
            request.setAttribute("msg","Usuario/Senha Invalidos");
            request.setAttribute("page","index.html");
            RequestDispatcher rd = getServletContext().
            getRequestDispatcher("/Index.jsp");
            rd.forward(request, response);
                    
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");  
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
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
