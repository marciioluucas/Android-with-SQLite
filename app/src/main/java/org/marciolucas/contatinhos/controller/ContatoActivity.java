package org.marciolucas.contatinhos.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.marciolucas.contatinhos.R;
import org.marciolucas.contatinhos.model.Contatinho;
import org.marciolucas.contatinhos.service.ContatinhoDAO;

public class ContatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        final EditText txtNome = (EditText) findViewById(R.id.txtNome);
        final EditText txtTelefone = (EditText) findViewById(R.id.txtTelefone);
        final EditText txtInfos = (EditText) findViewById(R.id.txtInfos);

        Button btn = (Button) findViewById(R.id.cadastrar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNome.toString() == null && txtNome.toString().equals("")) {
                    Toast t = Toast.makeText(getApplicationContext(), "Nome é requirido", Toast.LENGTH_SHORT);
                    t.show();
                }
                else if (txtTelefone.toString() == null && txtTelefone.toString().equals("")) {
                    Toast t = Toast.makeText(getApplicationContext(), "Nome é requirido", Toast.LENGTH_SHORT);
                    t.show();
                }
                else {
                    Contatinho c = new Contatinho();
                    ContatinhoDAO dao = new ContatinhoDAO(getApplicationContext());
                    c.setNome(txtNome.getText().toString());
                    c.setTelefone(txtTelefone.getText().toString());
                    c.setInfos(txtInfos.getText().toString());
                   if(dao.insert(c)){
                       Toast.makeText(getApplicationContext() , "Contatinho cadastrado", Toast.LENGTH_SHORT).show();
                   }else{
                       Toast.makeText(getApplicationContext(), "Contatinho não cadastrado", Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });
    }
}
