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
import java.util.ArrayList;
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
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

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
        LoginBean logado = (LoginBean) session.getAttribute("logado");
        try {
                if (logado == null){
                request.setAttribute("msg","Usuario deve se autenticar para acessar o sistema.");
                RequestDispatcher rd = getServletContext().
                getRequestDispatcher("/Index.jsp");
                rd.forward(request, response);  
               }
                else{
                    String action = request.getParameter("action");
                    
                    if(action != null){
                        ClienteDAO dao = new ClienteDAO();
                        switch(action){
                        case "show":
                            {
                                String ids = request.getParameter("id");
                                List<Cliente> p = dao.buscarUM(ids);
                                
                                for(Cliente s : p)
                                    request.setAttribute("s",s);
                                
                                RequestDispatcher rd = getServletContext().
                                    getRequestDispatcher("/ClientesVisualizar.jsp");
                                rd.forward(request, response);
                                break;
                            }
                            case "ver":
                            {
                                List<Cliente> listando = dao.buscarTodos();
                                request.setAttribute("cliente",listando);
                                RequestDispatcher rd = getServletContext().
                                        getRequestDispatcher("/ListarCliente.jsp");
                                rd.forward(request,response);
                                break;
                            }
                        case "formUpdate":
                            {
                                String ids = request.getParameter("id");
                                List<Cliente> a = dao.buscarUM(ids);
                                for(Cliente s : a)
                                    request.setAttribute("alterar",s);
                                
                                RequestDispatcher rd = getServletContext().
                                    getRequestDispatcher("/ClienteAlterar.jsp");
                                rd.forward(request, response);
                                break;
                            }
                        case "remove":
                            {
                                String ids = request.getParameter("id");
                                dao.excluiCliente(ids);
                                RequestDispatcher rd = getServletContext().
                                    getRequestDispatcher("/ClienteServlet?action=ver");
                                rd.forward(request, response);
                                break;
                            }
                        case "update":
                            {
                                String ids = request.getParameter("id");
                                String nome = (String) request.getParameter("nome");
                                String email = (String) request.getParameter("email");
                                String cpf = (String) request.getParameter("cpf");
                                String cidade = (String) request.getParameter("cidade");
                                String rua = (String) request.getParameter("rua");
                                String uf = (String) request.getParameter("uf");
                                String cep = (String) request.getParameter("cep");
                                String nrs = (String) request.getParameter("numero");
                                int nr =  Integer.parseInt(nrs);
                                
                                Cliente p = new Cliente();
                                p.setNome(nome);
                                p.setEmail(email);
                                p.setCpf(cpf);
                                p.setCidade(cidade);
                                p.setUf(uf);
                                p.setRua(rua);
                                p.setCep(cep);
                                p.setNr(nr);
                                
                                dao.AlteraCliente(p, ids);
                                RequestDispatcher rd = getServletContext().
                                    getRequestDispatcher("/ClienteServlet?action=ver");
                                rd.forward(request, response);
                                break;
                            }
                        case "formNew":
                            {
                                
                                RequestDispatcher rd = getServletContext().
                                    getRequestDispatcher("/clientesnovo.jsp");
                                rd.forward(request, response);
                                break;
                            }
                        case "new":
                            {
                                
                                String nome = (String) request.getParameter("nome");
                                String email = (String) request.getParameter("email");
                                String cpf = (String) request.getParameter("cpf");
                                String cidade = (String) request.getParameter("cidade");
                                String rua = (String) request.getParameter("rua");
                                String uf = (String) request.getParameter("uf");
                                String cep = (String) request.getParameter("cep");
                                String nrs = (String) request.getParameter("numero");
                                int nr =  Integer.parseInt(nrs);
                                
                                Cliente p = new Cliente();
                                p.setNome(nome);
                                p.setEmail(email);
                                p.setCpf(cpf);
                                p.setCidade(cidade);
                                p.setUf(uf);
                                p.setRua(rua);
                                p.setCep(cep);
                                p.setNr(nr);
                                
                                dao.inserirCliente(p);
                                
                                RequestDispatcher rd = getServletContext().
                                    getRequestDispatcher("/ClienteServlet?action=ver");
                                rd.forward(request, response);
                                break;
                            }
                        default:
                            {
                                RequestDispatcher rd = getServletContext().
                                        getRequestDispatcher("/Erro.jsp");
                                rd.forward(request,response);
                                break;
                            }
                        }
                    }
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
