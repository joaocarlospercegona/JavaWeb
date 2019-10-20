/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Cliente;
import Beans.LoginBean;
import DAO.ClienteDAO;
import DAO.UsuarioDAO;
import static facade.ClienteFacade.insere;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "NovoCliente", urlPatterns = {"/NovoCliente"})
public class NovoCliente extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        LoginBean logado = (LoginBean) session.getAttribute("logado");
        try {
                if (logado == null){
                request.setAttribute("msg","Usuario deve se autenticar para acessar o sistema.");
                RequestDispatcher rd = getServletContext().
                getRequestDispatcher("/Index.jsp");
                rd.forward(request, response);  
               }
                else{
                    
                    String nome = (String) request.getParameter("nome");
                    String email = (String) request.getParameter("email");
                    String cpf = (String) request.getParameter("cpf");
                    String cidade = (String) request.getParameter("cidade");
                    String rua = (String) request.getParameter("rua");
                    String uf = (String) request.getParameter("uf");
                    String cep = (String) request.getParameter("cep");
                    String nrs = (String) request.getParameter("numero");
                    int nr =  Integer.parseInt(nrs);
                    //out.println(nr);
                    //Date data = ;
                    
                    
                        Cliente p = new Cliente();
                        p.setNome(nome);
                        p.setEmail(email);
                        p.setCpf(cpf);
                        p.setCidade(cidade);
                        p.setUf(uf);
                        p.setRua(rua);
                        p.setCep(cep);
                        p.setNr(nr);
                        
                        out.println("indo");
                        ClienteDAO dao = new ClienteDAO();
                        insere(p);
                        out.println("b");
                        request.setAttribute("creio", "a");
                        RequestDispatcher rd = request.
                            getRequestDispatcher("ClienteServlet");
                        rd.forward(request, response);  
                  }
        }
         catch(Exception e){
             e.printStackTrace();
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
