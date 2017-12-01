package org.marciolucas.contatinhos.model;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.marciolucas.contatinhos.service.ContatinhoDAO;

/**
 * Created by marci on 14/11/2017.
 */

public class Curtida {
    private Context context;
    private Contatinho contatinho;


    public Curtida(Context context, Contatinho contatinho) throws Exception {
        this.contatinho = contatinho;
        this.context = context;
    }

    public Boolean curtir() throws Exception {
        ContatinhoDAO contatinhoDAO = new ContatinhoDAO(this.context);
        try {
            ContatinhoDAO dao = new ContatinhoDAO(this.context);
            Contatinho rtrvById = dao.retreaveById(contatinho.getId());

            if(rtrvById == null){
                contatinho.setCurtida(true);
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
