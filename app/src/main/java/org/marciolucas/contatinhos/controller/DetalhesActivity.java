package org.marciolucas.contatinhos.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.marciolucas.contatinhos.R;
import org.marciolucas.contatinhos.model.Contatinho;
import org.marciolucas.contatinhos.model.Curtida;
import org.marciolucas.contatinhos.service.ContatinhoImpl;

public class DetalhesActivity extends AppCompatActivity {
    private Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        final Contatinho contatinho = new Gson().fromJson(getIntent().getStringExtra("contatinho"), Contatinho.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tel = (TextView) findViewById(R.id.tel);
        TextView info = (TextView) findViewById(R.id.infos);
        FloatingActionButton btnDelete = (FloatingActionButton) findViewById(R.id.btnDelete);
        tel.setText(contatinho.getTelefone());
        info.setText(contatinho.getInfos());

        setTitle(contatinho.getNome());
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final FloatingActionButton edit = (FloatingActionButton) findViewById(R.id.fabEdit);
        final FloatingActionButton voltar = (FloatingActionButton) findViewById(R.id.voltar);

        contatinho.setCurtida(false);
        fab.setImageResource(R.drawable.favorite_border_black_192x192);


        if (contatinho.getIsCurtida()) {
            ImageView imgV = (ImageView) findViewById(R.id.imageGif);
            Glide.with(activity).load(R.mipmap.giphy).into(imgV);
            fab.setImageResource(R.drawable.favorite_border_black_broken192x192);

        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContatinhoImpl dao = new ContatinhoImpl(getApplicationContext());
                Contatinho rtrvById = dao.retreaveById(contatinho.getId());
                contatinho.setCurtida(false);
                String txtResposta = "Contatinho descurtido: ";
                fab.setImageResource(R.drawable.favorite_border_black_192x192);
                if (!rtrvById.getIsCurtida()) {
                    contatinho.setCurtida(true);
                    txtResposta = "Contatinho curtido: ";
                    fab.setImageResource(R.drawable.favorite_border_black_broken192x192);
                }


                if (dao.update(contatinho)!=-1) {
                    ImageView imgV = (ImageView) findViewById(R.id.imageGif);
                    Glide.with(activity).load(R.mipmap.giphy).into(imgV);
                    Snackbar.make(view, txtResposta + contatinho.getNome(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, ContatoActivity.class);
                i.putExtra("contatinho",new Gson().toJson(contatinho));
                startActivity(i);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContatinhoImpl dao = new ContatinhoImpl(getApplicationContext());
                dao.delete(contatinho);
                startActivity(new Intent(activity, MainActivity.class));
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, MainActivity.class));
            }
        });

    }
}
