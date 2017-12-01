package org.marciolucas.contatinhos.service;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Admin on 30/11/2017.
 */

public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCIA;

    public abstract ContatinhoDAO contatinhoDAO();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCIA == null) {
            Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "country-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCIA;
    }

    public static void destroyInstance() {
        INSTANCIA = null;
    }

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
