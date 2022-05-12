package com.example.actividad_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewTreeObserver;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Juego_JGG extends AppCompatActivity {

    private Handler handler = new Handler();
    private Random random = new Random();
    int nivel=20;
    private MediaPlayer musicaJuego_JGG = new MediaPlayer();
public ElementosGraficos_JGG p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_jgg);
        musicaJuego_JGG = MediaPlayer.create(this,R.raw.iiiii);
        musicaJuego_JGG.start();
        musicaJuego_JGG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                musicaJuego_JGG.start(); }});
        p=findViewById(R.id.ElementosGraficos_JGG);

        ViewTreeObserver obs=p.getViewTreeObserver();
        obs.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override public void onGlobalLayout() {
        //Condiciones iniciales de la aplicacion respecto a posicion de los elementos
        p.ancho_JGG = p.getWidth();p.alto_JGG =p.getHeight();
        p.posicionAnchoCesta_JGG =p.ancho_JGG /2;
        p.posicionAltoCesta_JGG = (float) (p.alto_JGG /1.1);
        p.radio_JGG =100;
        p.posicionAnchoComidaBasura1_JGG =random.nextInt(p.ancho_JGG);
        p.posicionAnchoFruta1_JGG = random.nextInt(p.ancho_JGG);
        p.posicionAltoComidaBasura1_JGG = (float) (p.alto_JGG);
        p.posicionAltoComidaBasura2_JGG = (float) (-p.alto_JGG);

            }});
        //Este timer_JGG es la clase principal para generar la repeticion de las imagenes
        //el objeto que creemos con el nos servira para cerar el juego mas adelante por ejemplo
        Timer timer_JGG = new Timer();
            timer_JGG.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        public void run() {
                            //Es te if es el reponsable deaumentar de nivel generando nuevas condiciones
                            if (p.puntOS_JGG >2) {




                                //el movimient de la afruta aumentara sumandose este mas 15 al movimiento fuera del if
                                p.posicionAltoFruta1_JGG += 15;
                                p.posicionAltoComidaBasura1_JGG += 15;
                                p.posicionAltoComidaBasura2_JGG += 30;
                                            // Si la posicion baja de cero cambiara de activity a uno con game over
                                            if (p.puntOS_JGG <0) {
                                                musicaJuego_JGG.pause();
                                                Intent miIntent = new Intent (Juego_JGG.this, gameOver_JGG.class);
                                                startActivity(miIntent);
                                                timer_JGG.cancel();}
                                            // Si la posicion sube mas de 10 cambiara de activity a uno victoria
                                            if (p.puntOS_JGG >10){
                                                musicaJuego_JGG.pause();
                                                Intent miIntent = new Intent(Juego_JGG.this, retoConseguido_JGG.class);
                                                startActivity(miIntent);
                                                timer_JGG.cancel();}}
                            // este if genera un fin del juego en el nivel principal
                            if (p.puntOS_JGG <0) {
                                musicaJuego_JGG.pause();
                                Intent miIntent = new Intent (Juego_JGG.this, gameOver_JGG.class);
                                startActivity(miIntent);
                                timer_JGG.cancel();}
                            // genera un movimiento de inicial
                            p.posicionAltoFruta1_JGG += 15;
                            p.posicionAltoComidaBasura1_JGG += 15;
                            //refreca la pantalla y llama al draw
                            p.invalidate();
                        }}); }}, 0, nivel); }}