/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Cliente;
import Beans.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao
 */
public class ClienteDAO {
    public ClienteDAO(){
    }
    public List<Cliente> buscarTodos() {
        
        List<Cliente> resultado = new ArrayList<Cliente>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT * from tabela_cliente");
            rs = st.executeQuery();
            
            while (rs.next()){
              Cliente p = new Cliente();
              p.setId(rs.getInt("id"));
              p.setNome(rs.getString("nome"));
              p.setCpf(rs.getString("cpf"));
              p.setEmail(rs.getString("email"));
              p.setCep(rs.getString("cep"));
              p.setCidade(rs.getString("cidade"));
              p.setUf(rs.getString("uf"));
              p.setNr(rs.getInt("nr"));
              p.setRua(rs.getString("rua"));
              p.setData(rs.getDate("data_cliente"));
              
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
    
    public List<Cliente> buscarUM(String id) {
        
        List<Cliente> resultado = new ArrayList<Cliente>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int i;
        i = Integer.parseInt(id);
        
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT * from tabela_cliente");
            rs = st.executeQuery();
            
            while (rs.next()){
              if(i == rs.getInt("id")){ 
              Cliente p = new Cliente();
              p.setId(rs.getInt("id"));
              p.setNome(rs.getString("nome"));
              p.setCpf(rs.getString("cpf"));
              p.setEmail(rs.getString("email"));
              p.setCep(rs.getString("cep"));
              p.setCidade(rs.getString("cidade"));
              p.setUf(rs.getString("uf"));
              p.setNr(rs.getInt("nr"));
              p.setRua(rs.getString("rua"));
              p.setData(rs.getDate("data_cliente"));
              resultado.add(p);
              }
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
    
    public void AlteraCliente(Cliente cliente, String id) throws ClassNotFoundException{
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            con = ConnectionFactory.getConnection();
           
            st = con.prepareStatement("UPDATE tabela_cliente SET nome = ?, cpf = ?, email = ?, rua = ?, nr = ?, cep = ?, cidade = ?, uf = ? WHERE id = "+id);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getCpf());
            st.setString(3, cliente.getEmail());
            st.setString(4, cliente.getRua());
            st.setInt(5, cliente.getNr());
            st.setString(6, cliente.getCep());
            st.setString(7, cliente.getCidade());
            st.setString(8, cliente.getUf());
            //st.setInt(4, cliente.getId());                       MEXER AQUI DEPOIS
            System.out.println(cliente.getNome() + id);
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
    
    
    public void excluiCliente(String id) throws ClassNotFoundException{
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("delete from tabela_cliente where id = " + id);
            st.executeUpdate();
        }
        catch (SQLException e) {
           throw new RuntimeException(e);
        } finally {
            if (st!=null)
                try {st.close();} catch (SQLException e){}
            if (con!=null)
                try {con.close();} catch (SQLException e){}
        }
    }
    
    
    
    
    //parei aqui
    
    
   
    public void inserirCliente(Cliente pessoa) throws ClassNotFoundException{
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            con = ConnectionFactory.getConnection();
           
            st = con.prepareStatement("INSERT INTO tabela_cliente (nome,cpf,email,data_cliente,rua,nr,cep,cidade,uf) VALUES (?,?,?,?,?,?,?,?,?)");
            st.setString(1, pessoa.getNome());
            st.setString(2, pessoa.getCpf());
            st.setString(3, pessoa.getEmail());
            
            
            //st.setDate(4, (Date) pessoa.getData());
            st.setString(5, pessoa.getRua());
            st.setInt(6, pessoa.getNr());
            st.setString(7, pessoa.getCep());
            st.setString(8, pessoa.getCidade());
            st.setString(9, pessoa.getUf());
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
