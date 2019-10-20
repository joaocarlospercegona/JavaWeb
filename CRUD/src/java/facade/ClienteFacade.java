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
        ClienteDAO dao = new ClienteDAO();
        dao.create(pessoa);
    }
    public static void altera(Cliente cliente, String id){ 
        ClienteDAO dao = new ClienteDAO();
        dao.edit(cliente); //tirei :  , id
    }
    public static void exclui(String idd){
        int id = Integer.parseInt(idd); //gambiarra
        ClienteDAO dao = new ClienteDAO();
        dao.destroy(id);
    }
    public static Cliente busca(String idd){
            int id = Integer.parseInt(idd); //gambiarra
            ClienteDAO dao = new ClienteDAO();
            //List<Cliente> c = dao.find(id);
                //for(Cliente p : c){
                    return dao.find(id);
                //}
        //return null;
    }
    public static List<Cliente> buscaTodos(){
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> c = dao.findEntities();
        return c;
    }
}
