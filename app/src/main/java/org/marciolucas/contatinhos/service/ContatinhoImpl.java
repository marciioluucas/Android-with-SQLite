package org.marciolucas.contatinhos.service;

import android.arch.persistence.room.Dao;
import android.content.Context;

import org.marciolucas.contatinhos.model.Contatinho;

import java.util.List;

/**
 * Created by Márcio Lucas R Oliveira <marciioluucas@gmail.com> on 09/11/2017.
 */

@Dao
public class ContatinhoImpl implements IContatinhoDAO {


    private AppDatabase appDatabase;

    public ContatinhoImpl(Context context) {
        this.appDatabase = AppDatabase.getAppDatabase(context);
    }


    public Long insert(Contatinho c) {
        return this.appDatabase.contatinhoDAO().insert(c);
    }

    public List<Contatinho> retreaveAll() {
        return this.appDatabase.contatinhoDAO().retreaveAll();
    }

    public Contatinho retreaveById(Long id) {

        return this.appDatabase.contatinhoDAO().retreaveById(id);
    }

    public List<Contatinho> retreaveByCurtida() {

        return this.appDatabase.contatinhoDAO().retreaveByCurtida();
    }

    public int update(Contatinho c) {
        return this.appDatabase.contatinhoDAO().update(c);
    }

    public int delete(Contatinho c) {
        return this.appDatabase.contatinhoDAO().delete(c);
    }


}
