package org.marciolucas.contatinhos.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.marciolucas.contatinhos.R;
import org.marciolucas.contatinhos.model.Contatinho;
import org.marciolucas.contatinhos.service.ContatinhoImpl;

public class ContatoActivity extends AppCompatActivity {
    private Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_contato);


        final EditText txtNome = (EditText) findViewById(R.id.txtNome);
        final EditText txtTelefone = (EditText) findViewById(R.id.txtTelefone);
        final EditText txtInfos = (EditText) findViewById(R.id.txtInfos);

        if (getIntent().hasExtra("contatinho")) {
            Contatinho contatinhoFromIntent = new Gson().fromJson(getIntent().getStringExtra("contatinho"), Contatinho.class);
            txtNome.setText(contatinhoFromIntent.getNome());
            txtTelefone.setText(contatinhoFromIntent.getTelefone());
            txtInfos.setText(contatinhoFromIntent.getInfos());
        }


        Button btn = (Button) findViewById(R.id.cadastrar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNome.toString() == null || txtNome.toString().equals("")) {
                    Toast t = Toast.makeText(getApplicationContext(), "Nome é requirido", Toast.LENGTH_SHORT);
                    t.show();

                } else if (txtTelefone.toString() == null || txtTelefone.toString().equals("")) {
                    Toast t = Toast.makeText(getApplicationContext(), "Nome é requirido", Toast.LENGTH_SHORT);
                    t.show();
                } else {
                    Contatinho c = new Contatinho();
                    ContatinhoImpl dao = new ContatinhoImpl(getApplicationContext());
                    c.setNome(txtNome.getText().toString());
                    c.setTelefone(txtTelefone.getText().toString());
                    c.setInfos(txtInfos.getText().toString());

                    if (getIntent().hasExtra("contatinho")) {
                        Contatinho contatinhoFromIntent = new Gson().fromJson(getIntent().getStringExtra("contatinho"), Contatinho.class);
                        c.setId(contatinhoFromIntent.getId());

                        if (dao.update(c) != -1) {
                            Toast.makeText(getApplicationContext(), "Contatinho alterado", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(activity, DetalhesActivity.class);
                            i.putExtra("contatinho", new Gson().toJson(c));
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Contatinho não alterado", Toast.LENGTH_SHORT).show();
                        }
                    } else {

                        if (dao.insert(c) != -1) {
                            Toast.makeText(getApplicationContext(), "Contatinho cadastrado", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(activity, MainActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Contatinho não cadastrado", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
        });
    }
}
