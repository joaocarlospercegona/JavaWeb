/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author joao
 */
public class Cliente implements Serializable{
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String rua;
    private String cidade;
    private String cep;
    private String uf;
    private int nr;
    private Date data;
    
    
    public Cliente(){
    }

    public Cliente(int id, String nome, String cpf, String email, String rua, String cidade, String cep, String uf, int nr, Date data) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.nr = nr;
        this.data = data;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
