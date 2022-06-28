package br.com.senac.atividadedelista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaração de variáveis globais

    ListView lstInformacoes;

    //Criando dados para a lista

    String titulo[] = {
            "Lua IO",
            "Netuno",
            "Particulas Elementares",
            "Constelação Reticulum",
            "Saturno",
            "Urano"
    };


    int imgInformacoes[] = {
            R.drawable.io,
            R.drawable.netuno,
            R.drawable.particulas,
            R.drawable.reticulum,
            R.drawable.saturno,
            R.drawable.urano
    };

    String descricao[] = {
            "Lua de júpiter IO",
            "Planeta netuno e suas diversidades",
            "Estudo novo de física de particulas",
            "Constelação de reticulum consta nova descoberta",
            "Saturno possui alterações químicas em seu anel",
            "Anel de urano é descoberto com novas alterações"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstInformacoes = findViewById(R.id.listaInfo);

        MyAdapter adapter = new MyAdapter();

        lstInformacoes.setAdapter(adapter);

        lstInformacoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Abrindo janela e passando valores

                Intent intent = new Intent(getApplication(), apresentacao.class);

                intent.putExtra("Titulo", titulo[position]);
                intent.putExtra("Descricao", descricao[position]);

                startActivity(intent);
            }
        });
    }
    //Criando uma classe interna inner class

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgInformacoes.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Criando variáveis para os componentes

            ImageView imagemInformacoes;

            TextView txtTitulo, txtDescricao;

            //Instanciando e carregando o modelo ao adaptador

            View view1 = getLayoutInflater().inflate(R.layout.activity_apresentacao, null);

            txtTitulo = view1.findViewById(R.id.txtTitulo);
            txtDescricao = view1.findViewById(R.id.txtDescricao);
            imagemInformacoes = view1.findViewById(R.id.imageDemo);


            //Passando os valroes para o componente do modelo

            txtTitulo.setText(titulo[position]);
            txtDescricao.setText(descricao[position]);
            imagemInformacoes.setImageResource(imgInformacoes[position]);

            return view1;
        }
    }
}