/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Beans.Cliente;
import DAO.ClienteDAO;
import java.util.List;

/**
 *
 * @author lps
 */
public class ClientesFacade {

    public static void inserir(Cliente c) throws ClassNotFoundException{ //fica pedindo pra por "ClassNotFoundException", errado?
        ClienteDAO dao = new ClienteDAO();
        dao.inserirCliente(c);
    };

    public static void alterar(Cliente c, String ids) throws ClassNotFoundException{ //coloquei "String ids", pode?
        ClienteDAO dao = new ClienteDAO();
        dao.AlteraCliente(c, ids);
    };

     public static void remover(String ids) throws ClassNotFoundException{ //criado mas não pedido pelo professor?
          ClienteDAO dao = new ClienteDAO();
        dao.excluiCliente(ids);
    };
    
    
    
    
    public static Cliente buscar(int id){
        String ID = Integer.toString(id); 
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> p = dao.buscarUM(ID);

                            for (Cliente s : p) {
                                return s;
                            }
        return null;
    };

    public static List<Cliente> buscarTodos(){
        ClienteDAO dao = new ClienteDAO();
        return dao.buscarTodos();
    };

}
