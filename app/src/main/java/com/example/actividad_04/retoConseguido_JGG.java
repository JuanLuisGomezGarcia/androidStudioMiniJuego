package com.example.actividad_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class retoConseguido_JGG extends AppCompatActivity {


    MediaPlayer musicaVictoria_JGG = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reto_conseguido_jgg);
//musica de la actividad
        musicaVictoria_JGG = MediaPlayer.create(this,R.raw.yyy);
        musicaVictoria_JGG.start();
        musicaVictoria_JGG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                musicaVictoria_JGG.start(); }}); }
// boton para volver al menu
    public void retoConseguido_JGG(View view) {
        musicaVictoria_JGG.pause();
        Intent miIntent = new Intent(retoConseguido_JGG.this, Menu_JGG.class);
        startActivity(miIntent); }}