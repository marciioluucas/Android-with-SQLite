package org.marciolucas.contatinhos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Márcio Lucas R Oliveira <marciioluucas@gmail.com> on 09/11/2017.
 */

public class ContatinhoDAO {

    private ContatinhoDbHelper contatinhoDbHelper;
    private SQLiteDatabase SQLdbWritable = this.contatinhoDbHelper.getWritableDatabase();

    public ContatinhoDAO(Context context) {
        this.contatinhoDbHelper = new ContatinhoDbHelper(context);
    }


    public boolean insert(Contatinho c) {

        ContentValues values = new ContentValues();
        values.put(ContatinhoContract.COLUNA_NOME, c.getNome());
        values.put(ContatinhoContract.COLUNA_TELEFONE, c.getTelefone());
        values.put(ContatinhoContract.COLUNA_INFO, c.getInfos());
        long rows = this.SQLdbWritable.insert(ContatinhoContract.NOME_TABELA, null, values);
        return rows != -1;
    }

    public ArrayList<Contatinho> retreaveAll() {
        SQLiteDatabase db = this.contatinhoDbHelper.getWritableDatabase();
        String[] colunas = {ContatinhoContract.COLUNA_ID, ContatinhoContract.COLUNA_NOME, ContatinhoContract.COLUNA_TELEFONE, ContatinhoContract.COLUNA_INFO};
        Cursor c = db.query(ContatinhoContract.NOME_TABELA, colunas, null, null, null, null, ContatinhoContract.COLUNA_NOME + " ASC");
        ArrayList<Contatinho> contatinhos = new ArrayList<>();

        c.moveToFirst();
        while (c.moveToNext()) {
            Contatinho contato = new Contatinho();

            contato.setId(c.getInt(c.getColumnIndex(ContatinhoContract.COLUNA_ID)));
            contato.setNome(c.getString(c.getColumnIndex(ContatinhoContract.COLUNA_NOME)));
            contato.setTelefone(c.getString(c.getColumnIndex(ContatinhoContract.COLUNA_TELEFONE)));
            contato.setInfos(c.getString(c.getColumnIndex(ContatinhoContract.COLUNA_INFO)));
            contatinhos.add(contato);
        }

        c.close();
        return contatinhos;
    }


    public boolean update(Contatinho c) {
        ContentValues values = new ContentValues();
        values.put(ContatinhoContract.COLUNA_NOME, c.getNome());
        values.put(ContatinhoContract.COLUNA_TELEFONE, c.getTelefone());
        values.put(ContatinhoContract.COLUNA_INFO, c.getInfos());
        String cond = ContatinhoContract.COLUNA_ID + " = ?";
        String[] args = {c.getId().toString()};
        long rows = this.SQLdbWritable.update(ContatinhoContract.NOME_TABELA, values, cond, args);
        return rows != -1;
    }


    public boolean delete(Integer id) {
        String restriction = ContatinhoContract.COLUNA_ID + " = ? ";
        String[] arguments = {id.toString()};
        long rows = this.SQLdbWritable.delete(ContatinhoContract.NOME_TABELA, restriction, arguments);

        return rows > 0;
    }


}
