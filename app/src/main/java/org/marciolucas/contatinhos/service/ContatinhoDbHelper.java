package org.marciolucas.contatinhos.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Márcio Lucas R Oliveira <marciioluucas@gmail.com> on 09/11/2017.
 */

final class ContatinhoDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS " + ContatinhoContract.NOME_TABELA + "( " +
            ContatinhoContract.COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ContatinhoContract.COLUNA_NOME + " TEXT, " +
            ContatinhoContract.COLUNA_TELEFONE + " TEXT, " +
            ContatinhoContract.COLUNA_INFO + " TEXT, " +
            ContatinhoContract.COLUNA_IS_CURTIDA + " BOOLEAN DEFAULT 0); ";

    private static final String SQL_DROP = "DROP TABLE IF EXISTS " + ContatinhoContract.NOME_TABELA + ";";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "agendaCrush.db";

    ContatinhoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int vAntiga, int vNova) {
        db.execSQL(SQL_DROP);
        onCreate(db);
    }
}
