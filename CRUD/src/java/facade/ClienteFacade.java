/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Beans.Cliente;
import DAO.ClienteDAO;
import static java.lang.System.out;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joao
 */
public class ClienteFacade {
    
    
    
    
    public static void insere(Cliente pessoa){
        try {
            ClienteDAO dao = new ClienteDAO();
            dao.inserirCliente(pessoa);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void altera(Cliente cliente, String id){
        try {
            ClienteDAO dao = new ClienteDAO();
            dao.AlteraCliente(cliente, id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void exclui(String id){
        try {
            ClienteDAO dao = new ClienteDAO();
            dao.excluiCliente(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Cliente busca(String id){
        try{
            ClienteDAO dao = new ClienteDAO();
            List<Cliente> c = dao.buscarUM(id);
                for(Cliente p : c){
                    return p;
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static List<Cliente> buscaTodos(){
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> c = dao.buscarTodos();
        return c;
    }
}
