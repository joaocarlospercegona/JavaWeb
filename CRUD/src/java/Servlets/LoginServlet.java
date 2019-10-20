/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.LoginBean;
import Beans.Usuario;
import DAO.UsuarioDAO;
import static facade.UsuarioFacade.buscaTodos;
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
        int i;
        
            if((usuario != null)&&(senha != null)){      
                try  {
                    //UsuarioDAO dao = new UsuarioDAO();
                    List<Usuario> lista = buscaTodos();
                    for (Usuario x: lista) {
                        if(usuario.equals(x.getUsuario())&&(senha.equals(x.getSenha()))){
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
                    request.setAttribute("msg","Usuario/Senha Invalidos");
                    request.setAttribute("page","index.html");
                    RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/Index.jsp");
                    rd.forward(request, response);
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }
            else{
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/Erro.jsp");
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
