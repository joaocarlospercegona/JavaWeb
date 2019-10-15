/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Beans.Cliente;
import DAO.ClienteDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joao
 */
public class ClienteFacade {
    public ClienteFacade(){
    }
    
    ClienteDAO dao = new ClienteDAO();
    
    public void insere(Cliente pessoa){
        try {
            dao.inserirCliente(pessoa);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void altera(Cliente cliente, String id){
        try {
            dao.AlteraCliente(cliente, id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void exclui(String id){
        try {
            dao.excluiCliente(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Cliente> busca(String id){
        List<Cliente> c = dao.buscarUM(id);
        return c;
    }
    public List<Cliente> buscaTodos(){
        List<Cliente> c = dao.buscarTodos();
        return c;
    }
}
