package org.marciolucas.contatinhos.model;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by marci on 14/11/2017.
 */

public class Usuario extends Pessoa {

    public Usuario(Context c) {
        this.context = c;
    }

    @Override
    public Boolean cadastrar() {
        return null;
    }

    @Override
    public Boolean alterar() {
        return null;
    }

    @Override
    public ArrayList<Contatinho> retreaveAll() {
        return null;
    }

    @Override
    public Pessoa retreaveById() {
        return null;
    }

    @Override
    public Boolean deletar() {
        return null;
    }
}
