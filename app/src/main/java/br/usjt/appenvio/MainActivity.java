package br.usjt.appenvio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarMensagem (View v){
//referência para o campo em que o usuário digita
        EditText mensagemEditText = findViewById(R.id.mensagemEditText);
//mensagem digitada pelo usuário
        String mensagem = mensagemEditText.getEditableText().toString();
//intent a ser enviado para o SO, a princípio vazio
        Intent enviarMensagemIntent = new Intent();
//a ação desejada é "SEND", que representa compartilhar conteúdo
        enviarMensagemIntent.setAction(Intent.ACTION_SEND);
//tipo do conteúdo manipulado especificado como um MIME Type
        enviarMensagemIntent.setType("text/plain");
//mensagem vai dentro do Intent, associada à constante EXTRA_TEXT
//para que possa ser "pega" pela Activity que receberá esse Intent
        enviarMensagemIntent.putExtra(Intent.EXTRA_TEXT, mensagem);
//construímos um Intent que "empacota" o atual e garante
// que a tela de escolha de app sempre apareça e que o usuário
//não possa selecionar um app padrão
        enviarMensagemIntent = Intent.createChooser(enviarMensagemIntent, null);
//envia o Intent para o Android
//qualquer Activity (até de outros apps) que, em tempo de intalação
//tiver especificado ser capaz de atender requisições cuja ACTION seja
//ACTION_SEND será considerada candidata pelo Android
        startActivity(enviarMensagemIntent);
    }
}