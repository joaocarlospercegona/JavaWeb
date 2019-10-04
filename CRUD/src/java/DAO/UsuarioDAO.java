/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao
 */
public class UsuarioDAO {
    public UsuarioDAO() {
    }
    
    public List<Usuario> buscarTodos() {
        
        List<Usuario> resultado = new ArrayList<Usuario>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT * from usuario");
            rs = st.executeQuery();
            
            while (rs.next()){
              Usuario p = new Usuario();
              p.setNome(rs.getString("nome"));
              p.setUsuario(rs.getString("usuario"));
              p.setSenha(rs.getString("senha"));
              resultado.add(p);
            }
            return resultado;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs!=null)
                try {rs.close();} catch (Exception e){}
            if (st!=null)
                try {st.close();} catch (Exception e){}
            if (con!=null)
                try {con.close();} catch (Exception e){}
        }
        //return null;
    }
    
    public void inserirPessoa(Usuario pessoa) throws ClassNotFoundException{
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            con = ConnectionFactory.getConnection();
           
            st = con.prepareStatement("INSERT INTO usuario (nome,usuario,senha) VALUES (?,?,?)");
            st.setString(1, pessoa.getNome());
            st.setString(2, pessoa.getUsuario());
            st.setString(3, pessoa.getSenha());
            System.out.println("Inserindo!");
            st.executeUpdate();
            
        } catch (SQLException e) {
           throw new RuntimeException(e);
        } finally {
            if (st!=null)
                try {st.close();} catch (SQLException e){}
            if (con!=null)
                try {con.close();} catch (SQLException e){}
        }
    }   
}
