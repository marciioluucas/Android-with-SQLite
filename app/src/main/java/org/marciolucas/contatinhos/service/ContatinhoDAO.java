package org.marciolucas.contatinhos.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.marciolucas.contatinhos.model.Contatinho;

import java.util.ArrayList;

/**
 * Created by Márcio Lucas R Oliveira <marciioluucas@gmail.com> on 09/11/2017.
 */

public class ContatinhoDAO implements IContatinhoDAO {


    private AppDatabase appDatabase;

    public ContatinhoDAO(Context context) {
        this.appDatabase = AppDatabase.getAppDatabase(context);
    }


    public boolean insert(Contatinho c) {
        return this.appDatabase.contatinhoDAO().insert(c);
    }

    public ArrayList<Contatinho> retreaveAll() {
        return this.appDatabase.contatinhoDAO().retreaveAll();
    }

    public Contatinho retreaveById(Long id) {

        return this.appDatabase.contatinhoDAO().retreaveById(id);
    }

    public ArrayList<Contatinho> retreaveByCurtida() {

        return this.appDatabase.contatinhoDAO().retreaveByCurtida();
    }

    public boolean update(Contatinho c) {
        return this.appDatabase.contatinhoDAO().update(c);
    }

    public boolean delete(Long id) {
        return this.appDatabase.contatinhoDAO().delete(id);
    }


}
