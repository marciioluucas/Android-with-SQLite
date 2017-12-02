package org.marciolucas.contatinhos.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.content.Context;

import org.marciolucas.contatinhos.service.ContatinhoImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Márcio Lucas R Oliveira <marciioluucas@gmail.com> on 09/11/2017.
 */
@Entity(tableName = "contatinhos")
public class Contatinho extends Pessoa {

    @ColumnInfo(name = "isCurtida")
    private boolean isCurtida = false;


    public Contatinho(Context c) {
        this.context = c;
    }

    public Contatinho() {

    }

    public boolean getIsCurtida() {
        return isCurtida;
    }

    public void setCurtida(boolean curtida) {
        isCurtida = curtida;
    }
}
