package org.marciolucas.contatinhos.model;

import android.content.Context;

import org.marciolucas.contatinhos.service.ContatinhoDAO;

import java.util.ArrayList;

/**
 * Created by Márcio Lucas R Oliveira <marciioluucas@gmail.com> on 09/11/2017.
 */

public class Contatinho extends Pessoa {

    private boolean isCurtida = false;


    public Contatinho(Context c) {
        this.context = c;
    }

    public Contatinho() {

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
        return new ContatinhoDAO(this.context).retreaveAll();
    }

    @Override
    public Pessoa retreaveById() {
        return null;
    }

    @Override
    public Boolean deletar() {
        return null;
    }

    public Boolean curtir() throws Exception {
        this.isCurtida = true;
        Curtida c = new Curtida(this.context, this);
        return c.curtir();
    }

    public boolean getIsCurtida() {
        return isCurtida;
    }

    public void setCurtida(boolean curtida) {
        isCurtida = curtida;
    }
}
