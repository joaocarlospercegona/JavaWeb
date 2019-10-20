/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Usuario;
import static java.rmi.server.LogStream.log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Beans.Cliente;
import Beans.Usuario;
import static java.rmi.server.LogStream.log;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author joao
 */
public class UsuarioDAO extends BaseDAOImp implements BaseDAO<Usuario> {
    
    public UsuarioDAO() {
      super();
    }

    @Override
        public List<Usuario> findEntities(boolean all, int maxResults, int firstResult) {

          List<Usuario> result = null;
          java.sql.PreparedStatement ps = null;
          java.sql.ResultSet rs = null;


        try {
          verificaConexao();
          ps = conn.prepareStatement("select nome_usuario "
                  + " from tb_usuario order by nome_usuario");
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new java.util.ArrayList<Usuario>();
                if (!all) {
                    int contagem = 1;  // primeiro next
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
              Usuario p = new Usuario();
              p.setNome(rs.getString("nome_usuario"));
              p.setUsuario(rs.getString("login_usuario"));
              p.setSenha(rs.getString("senha_usuario"));
              result.add(p);
            } while ((result.size() < maxResults || all) && rs.next());
        }

    } catch (java.sql.SQLException ex) {
        //log.severe("", ex);
    } finally {
        JDBCUtils.close(rs);
        JDBCUtils.close(ps);
    }
    return result;
}

@Override
public void create(Usuario pessoa) {
  java.sql.PreparedStatement ps = null;
  java.sql.ResultSet rs = null;
  String sql = "INSERT INTO tb_usuario (nome_usuario,login_usuario,senha_usuario) VALUES (?,?,?)";

        try {
            ps = getConnection().prepareStatement(sql);

            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getUsuario());
            ps.setString(3, pessoa.getSenha());

            if (ps.executeUpdate() == 0) {
                //log.warning(ps.toString() + " not inserted.");
            } else {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    pessoa.setID(rs.getInt(1));
                }
            }
        } catch (SQLException ex) {
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(ps);
        }

    }

    @Override
    public void edit(Usuario vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findEntities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findEntities(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
