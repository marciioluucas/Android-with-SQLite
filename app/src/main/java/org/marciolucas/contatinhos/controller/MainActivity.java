package org.marciolucas.contatinhos.controller;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.marciolucas.contatinhos.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            switch (item.getItemId()) {
                case R.id.lista:
                    setTitle("Lista");
                    ListaFragment fragment = new ListaFragment();
                    fragmentTransaction.replace(R.id.content, fragment, "tag1");
                    fragmentTransaction.commit();
                    break;
                case R.id.perfil:
                    setTitle("Perfil");
                    PerfilFragment fragment2 = new PerfilFragment();
                    fragmentTransaction.replace(R.id.content, fragment2, "tag2");
                    fragmentTransaction.commit();
                    break;
                case R.id.curtidas:
                    setTitle("Curtidas");
                    CurtidaFragment fragment3 = new CurtidaFragment();
                    fragmentTransaction.replace(R.id.content, fragment3, "tag3");
                    fragmentTransaction.commit();
                    break;
                default:
                    setTitle("Lista de contatinhos");
                    ListaFragment fragment4 = new ListaFragment();
                    fragmentTransaction.replace(R.id.content, fragment4, "tag4");
                    fragmentTransaction.commit();
            }

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, new ListaFragment());
        fragmentTransaction.commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }
}
