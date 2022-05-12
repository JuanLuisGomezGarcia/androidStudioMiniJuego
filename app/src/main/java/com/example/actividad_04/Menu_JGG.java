package com.example.actividad_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_JGG extends AppCompatActivity {


    private MediaPlayer musicaMenu = new MediaPlayer();
    Button botonInicio_JGG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jgg);
        botonInicio_JGG = findViewById(R.id.botonInicio_JGG);

        musicaMenu = MediaPlayer.create(this,R.raw.eee);
        musicaMenu.start();
        musicaMenu.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                musicaMenu.start(); }}); }

    public void iniciarJuego_JGG(View view) {
        musicaMenu.pause();
        Intent miIntent = new Intent (Menu_JGG.this, Juego_JGG.class);
        startActivity(miIntent); }}

