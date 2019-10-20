/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Beans.Cliente;
import Beans.Usuario;
import DAO.ClienteDAO;
import DAO.UsuarioDAO;
import java.util.List;

/**
 *
 * @author lps
 */
public class UsuarioFacade {
    public static void insere(Usuario pessoa){
        UsuarioDAO dao = new UsuarioDAO();
        dao.create(pessoa);
    }
    public static void altera(Usuario pessoa, String id){ 
        UsuarioDAO dao = new UsuarioDAO();
        dao.edit(pessoa); //tirei :  , id
    }
    public static void exclui(String idd){
        int id = Integer.parseInt(idd); //gambiarra
        UsuarioDAO dao = new UsuarioDAO();
        dao.destroy(id);
    }
    public static Usuario busca(String idd){
            int id = Integer.parseInt(idd); //gambiarra
            UsuarioDAO dao = new UsuarioDAO();
            //List<Cliente> c = dao.find(id);
                //for(Cliente p : c){
                    return dao.find(id);
                //}
        //return null;
    }
    public static List<Usuario> buscaTodos(){
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> c = dao.findEntities();
        return c;
    }
}
