package org.marciolucas.contatinhos.model;

import android.content.Context;

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
        Contatinho resultRet = contatinhoDAO.retreaveById(this.contatinho);
        try {
            if (resultRet != null) {
                Contatinho contatinhoToUpdate = new Contatinho();
                contatinhoToUpdate.setNome(this.contatinho.getNome());
                contatinhoToUpdate.setInfos(this.contatinho.getInfos());
                contatinhoToUpdate.setTelefone(this.contatinho.getTelefone());
                return contatinhoDAO.update(contatinhoToUpdate);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return false;
    }
}
