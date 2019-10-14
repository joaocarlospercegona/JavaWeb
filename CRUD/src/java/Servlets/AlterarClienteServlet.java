/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Cliente;
import Beans.LoginBean;
import DAO.ClienteDAO;
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
@WebServlet(name = "AlterarClienteServlet", urlPatterns = {"/AlterarClienteServlet"})
public class AlterarClienteServlet extends HttpServlet {

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
        String nome = (String) request.getParameter("nome");
        String cpf = (String) request.getParameter("cpf");
        String email = (String) request.getParameter("email");
        String rua = (String) request.getParameter("rua");
        String nrs = (String) request.getParameter("numero");
        int nr = Integer.parseInt(nrs);
        String cep = (String) request.getParameter("cep");
        String cidade = (String) request.getParameter("cidade");
        String uf = (String) request.getParameter("uf");
        String id= (String)  request.getParameter("id");   
        out.println(email);
        out.println(id);
        try {
               
            
            if (logado == null){
                request.setAttribute("msg","Usuario deve se autenticar para acessar o sistema.");
                RequestDispatcher rd = getServletContext().
                getRequestDispatcher("/Index.jsp");
                rd.forward(request, response);  
               }
                else{
                    
                    Cliente pessoa = new Cliente();
                    pessoa.setNome(nome);
                    pessoa.setCpf(cpf);
                    pessoa.setEmail(email);
                    pessoa.setRua(rua);
                    pessoa.setNr(nr);
                    pessoa.setCep(cep);
                    pessoa.setCidade(cidade);
                    pessoa.setUf(uf);
                    
                    //Para de funcionar aqui ver amanha
                     ClienteDAO dao = new ClienteDAO();
                     dao.AlteraCliente(pessoa, id);
                     
                     request.setAttribute("ai", "oi");
                     RequestDispatcher rd = request.
                        getRequestDispatcher("/ClienteServlet");
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
