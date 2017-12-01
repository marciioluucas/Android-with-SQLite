package org.marciolucas.contatinhos.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by marci on 14/11/2017.
 */
@Entity(tableName = "contatinhos")
public abstract class Pessoa {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "telefone")
    private String telefone;
    @ColumnInfo(name = "infos")
    private String infos;
    protected Context context;

    public abstract Boolean cadastrar();

    public abstract Boolean alterar();

    public abstract ArrayList<Contatinho> retreaveAll();

    public abstract Pessoa retreaveById();

    public abstract Boolean deletar();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
