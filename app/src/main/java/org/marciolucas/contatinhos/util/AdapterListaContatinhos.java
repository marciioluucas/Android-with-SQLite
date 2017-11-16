package org.marciolucas.contatinhos.util;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.marciolucas.contatinhos.R;
import org.marciolucas.contatinhos.controller.DetalhesActivity;
import org.marciolucas.contatinhos.model.Contatinho;

import java.util.List;

/**
 * Created by marci on 14/11/2017.
 */

public class AdapterListaContatinhos extends BaseAdapter {

    private final List<Contatinho> contatinhos;
    private final Activity activity;
    protected  Context context;

    public AdapterListaContatinhos(Context context, List<Contatinho> contatinhos, Activity activity) {
        this.contatinhos = contatinhos;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return contatinhos.size();
    }

    @Override
    public Object getItem(int position) {
        return contatinhos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contatinhos.get(position).getId();
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View v = this.activity.getLayoutInflater().inflate(R.layout.lista_contato_personalizada, parent, false);
        final Contatinho contatinho = contatinhos.get(position);
        TextView nome = (TextView)
                v.findViewById(R.id.lista_contato_personalizada_nome);
        TextView telefone = (TextView)
                v.findViewById(R.id.lista_contato_personalizada_telefone);
        ImageView imagem = (ImageView)
                v.findViewById(R.id.lista_contato_personalizada_imagem);

        nome.setText(contatinho.getNome());
        telefone.setText(contatinho.getTelefone());
        imagem.setImageResource(R.drawable.ic_home_black_24dp);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, DetalhesActivity.class);
                i.putExtra("contatinho",new Gson().toJson(contatinho));
                context.startActivity(i);
            }
        });
        return v;
    }
}
