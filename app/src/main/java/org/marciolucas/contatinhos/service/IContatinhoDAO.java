package org.marciolucas.contatinhos.service;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.marciolucas.contatinhos.model.Contatinho;

import java.util.ArrayList;

/**
 * Created by Admin on 30/11/2017.
 */

public interface IContatinhoDAO {
    @Insert
    boolean insert(Contatinho c);

    @Query("SELECT * FROM contatinhos")
    ArrayList<Contatinho> retreaveAll();

    @Update
    boolean update(Contatinho c);

    @Query("SELECT * FROM contatinhos where id = :id")
    Contatinho retreaveById(Long id);

    @Query("SELECT * FROM contatinhos where curtida = 1")
    ArrayList<Contatinho> retreaveByCurtida();

    @Delete
    boolean delete(Long id);

}
