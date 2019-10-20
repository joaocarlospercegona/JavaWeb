/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Cliente;
import Beans.Usuario;
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
public class ClienteDAO extends BaseDAOImp implements BaseDAO<Cliente>{
    
  private static final Logger log = Logger.getLogger(ClienteDAO.class.getName());
  
    public ClienteDAO(){
      super();
    }

    public ClienteDAO(java.sql.Connection con) {
        setConnection(con);
    }

    @Override
    public void create(Cliente pessoa) {
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;
      String sql = "INSERT INTO tabela_cliente (nome_cliente,cpf_cliente,email_cliente,data_cliente,rua_cliente,nr_cliente,cep_cliente,cidade_cliente,uf_cliente) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            ps = getConnection().prepareStatement(sql);

            Date dt = new Date();

            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCpf());
            ps.setString(3, pessoa.getEmail());
            ps.setDate(4, new java.sql.Date(dt.getTime()) );
            ps.setString(5, pessoa.getRua());
            ps.setInt(6, pessoa.getNr());
            ps.setString(7, pessoa.getCep());
            ps.setString(8, pessoa.getCidade());
            ps.setString(9, pessoa.getUf());

            if (ps.executeUpdate() == 0) {
                log.warning(ps.toString() + " not inserted.");
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
    public void edit(Cliente cliente) {
      if (cliente.getID() < 1) {
          log.warning("update ignored (not id defined) ");
          return;
      }
      java.sql.PreparedStatement ps = null;
      String sql = "UPDATE tabela_cliente SET nome_cliente = ?, cpf_cliente = ?, email_cliente = ?, rua_cliente = ?, nr_cliente = ?, cep_cliente = ?, cidade_cliente = ?, uf_cliente = ?  "
              + " where id_cliente = ?";

        try {
            ps = getConnection().prepareStatement(sql);

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getRua());
            ps.setInt(5, cliente.getNr());
            ps.setString(6, cliente.getCep());
            ps.setString(7, cliente.getCidade());
            ps.setString(8, cliente.getUf());

            if (ps.executeUpdate() == 0) {
                log.warning(ps.toString() + " not updated.");
            }
        } catch (SQLException ex) {
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(ps);
        }
    }

    @Override
    public void destroy(Integer id) {
      java.sql.PreparedStatement ps = null;
      String sql = "delete from tabela_cliente where id_cliente = ?";

      try {
          ps = getConnection().prepareStatement(sql);
          ps.setInt(1, id);
          if (ps.executeUpdate() == 0) {
              log.warning(ps.toString() + " not deleted.");
          }
      } catch (SQLException ex) {
          //log.severe("", ex);
      } finally {
          JDBCUtils.close(ps);
      }
    }

    @Override
    public void destroy(Cliente value) {
        destroy( value.getID() );
    }

    @Override
    public List<Cliente> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<Cliente> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

@Override
    public List<Cliente> findEntities(boolean all, int maxResults, int firstResult) {

      List<Cliente> result = null;
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;

        try {
          verificaConexao();
          ps = conn.prepareStatement("select nome_cliente "
                  + " from tabela_cliente order by nome_cliente");
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new java.util.ArrayList<Cliente>();
                if (!all) {
                    int contagem = 1;  // primeiro next
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
                  Cliente p = new Cliente();
                  p.setID(rs.getInt("id_cliente"));
                  p.setNome(rs.getString("nome_cliente"));
                  p.setCpf(rs.getString("cpf_cliente"));
                  p.setEmail(rs.getString("email_cliente"));
                  p.setCep(rs.getString("cep_cliente"));
                  p.setCidade(rs.getString("cidade_cliente"));
                  p.setUf(rs.getString("uf_cliente"));
                  p.setNr(rs.getInt("nr_cliente"));
                  p.setRua(rs.getString("rua_cliente"));
                  p.setData(rs.getDate("data_cliente"));

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
    public Cliente find(Integer id) {
        Cliente p = null;

        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "SELECT id_cliente,nome_cliente " +
        "from tabela_cliente where id_cliente = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
              p = new Cliente();
              p.setID(rs.getInt("id_cliente"));
              p.setNome(rs.getString("nome_cliente"));
              p.setCpf(rs.getString("cpf_cliente"));
              p.setEmail(rs.getString("email_cliente"));
             // p.setData(rs.getDate("data_cliente"));
              p.setCep(rs.getString("cep_cliente"));
              p.setCidade(rs.getString("cidade_cliente"));
              p.setUf(rs.getString("uf_cliente"));
              p.setNr(rs.getInt("nr_cliente"));
              p.setRua(rs.getString("rua_cliente"));
              p.setData(rs.getDate("data_cliente"));
            }
        } catch (SQLException ex) {
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return p;
    }


    public Cliente findByNome(String nome) {
        Cliente vo = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "select id_cliente,nome_cliente "
                + " from tb_cliente where nome_cliente = ?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            if (rs.next()) {
                vo = new Cliente();
                vo.setID(rs.getInt(1));
                vo.setNome(rs.getString(2));
            }
        } catch (SQLException ex) {
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return vo;
    }

    @Override
    public int getCount() {
        int result = 0;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "select count(1) from tb_cliente";
        try {
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException ex) {
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return result;
    }









}
