package br.com.senac.atividadedelista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class apresentacao extends AppCompatActivity {

    //Declaração das variáveis

    ImageView image;
    TextView  txtDescricao, txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentacao);

        txtDescricao = findViewById(R.id.txtDescricao);
        txtTitulo = findViewById(R.id.txtTitulo);
        image = findViewById(R.id.imageDemo);

        Intent intent = getIntent();

        String titulo = intent.getStringExtra("Titulo");
        String descricao = intent.getStringExtra("Descricao");
        int imagem = intent.getIntExtra("ImagemInformacao", 0);

        txtTitulo.setText(titulo);
        txtDescricao.setText(descricao);
        image.setImageResource(imagem);
    }
}
