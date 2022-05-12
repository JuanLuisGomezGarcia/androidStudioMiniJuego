package com.example.actividad_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class gameOver_JGG extends AppCompatActivity {
    private MediaPlayer musicaFinDelJuego_JGG = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_jgg);

        musicaFinDelJuego_JGG = MediaPlayer.create(this,R.raw.aaa);
        musicaFinDelJuego_JGG.start();
        musicaFinDelJuego_JGG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                musicaFinDelJuego_JGG.start(); }}); }
    public void volverInicio_JGG(View view) {
        musicaFinDelJuego_JGG.pause();
        Intent miIntent = new Intent (gameOver_JGG.this, Menu_JGG.class);
        startActivity(miIntent); }}