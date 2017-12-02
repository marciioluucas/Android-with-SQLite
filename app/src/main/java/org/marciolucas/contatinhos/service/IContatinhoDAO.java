package org.marciolucas.contatinhos.service;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.marciolucas.contatinhos.model.Contatinho;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 30/11/2017.
 */

@Dao
public interface IContatinhoDAO {
    @Insert
    Long insert(Contatinho c);

    @Query("SELECT * FROM contatinhos")
    List<Contatinho> retreaveAll();

    @Update
    int update(Contatinho c);

    @Query("SELECT * FROM contatinhos where id = :id")
    Contatinho retreaveById(Long id);

    @Query("SELECT * FROM contatinhos where isCurtida = 1")
    List<Contatinho> retreaveByCurtida();

    @Delete
    int delete(Contatinho contatinho);

}
