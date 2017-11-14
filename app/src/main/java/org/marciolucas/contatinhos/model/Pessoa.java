package org.marciolucas.contatinhos.model;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by marci on 14/11/2017.
 */

public abstract class Pessoa {
    private Integer id;
    private String nome;
    private String telefone;
    private String infos;
    protected Context context;

    public abstract Boolean cadastrar();
    public abstract Boolean alterar();
    public abstract ArrayList<Contatinho> retreaveAll();
    public abstract Pessoa retreaveById();
    public abstract Boolean deletar();

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }
}
