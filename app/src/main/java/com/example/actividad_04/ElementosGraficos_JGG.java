package com.example.actividad_04;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

// Extensión de una View. Totalmente necesario para dibujar
public class ElementosGraficos_JGG extends View {
    public int ancho_JGG, alto_JGG;
    public float escala_JGG;
    public float posicionAnchoCesta_JGG, posicionAltoCesta_JGG, radio_JGG, posicionAnchoFruta1_JGG, posicionAltoFruta1_JGG,
            posicionAltoComidaBasura1_JGG, posicionAnchoComidaBasura1_JGG, posicionAltoComidaBasura2_JGG, posicionAnchoComidaBasura2_JGG;
    public Integer puntOS_JGG =0;
    private GestureDetector gestos;
    private RectF rectCesta_JGG, rectFruta1_JGG, rectComidaBasura1_JGG, rectComidaBasura2_JGG;
    // variable que genera numeros ramdon
    private Random random_JGG = new Random();

    public ElementosGraficos_JGG(Context context) {
        super(context);
    }
    public ElementosGraficos_JGG(Context context, AttributeSet attrs) {
        super(context, attrs); }

    @Override public boolean onTouchEvent(MotionEvent event) {
    switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: break;
            case MotionEvent.ACTION_UP: break;
            case MotionEvent.ACTION_MOVE:
                posicionAnchoCesta_JGG =(int)event.getX();
                this.invalidate(); }return true; }

    public ElementosGraficos_JGG(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle); }@SuppressLint("DrawAllocation") @Override
    protected void onDraw(Canvas canvas) { super.onDraw(canvas);

        //Generan el dibujo de los elementos no su fisica
        Paint cesta = new Paint();
        Paint fruta1 = new Paint();
        Paint puntos = new Paint();
        Paint comidaBasura1 = new Paint();
        Paint comidaBasura2 = new Paint();
        // Bitmap hace un mapa de bit que luego introduciremos en el paint junto con su fisica
       Bitmap bitmapFruta1 = BitmapFactory.decodeResource(getResources(), R.drawable.banana);
       Bitmap bitmapCesta = BitmapFactory.decodeResource(getResources(),R.drawable.cesta);
       Bitmap bitmapComidaBasura1 = BitmapFactory.decodeResource(getResources(),R.drawable.donuuu);
       Bitmap bitmapComidaBasura2 = BitmapFactory.decodeResource(getResources(),R.drawable.donuuu);

// Esto sirve para practicar las fisicas antes de poner la imagen
// canvas.drawOval(rectMoneda, fruta1);
//cesta.setStyle(Paint.Style.FILL_AND_STROKE);
// cesta.setColor(Color.YELLOW);
        // Fisica de los puntos
        puntos.setTextAlign(Paint.Align.RIGHT);
        puntos.setTextSize(70);
        puntos.setColor(Color.WHITE);
        canvas.drawText("PUNTOS: "+ puntOS_JGG.toString(), ancho_JGG /4 , alto_JGG /10,puntos);

        // Fisica del elemento  y tamaño
        rectCesta_JGG =new RectF((posicionAnchoCesta_JGG - radio_JGG), (posicionAltoCesta_JGG - radio_JGG), (posicionAnchoCesta_JGG + radio_JGG), (posicionAltoCesta_JGG + radio_JGG));
        rectFruta1_JGG = new RectF((posicionAnchoFruta1_JGG - radio_JGG), (posicionAltoFruta1_JGG - radio_JGG), (posicionAnchoFruta1_JGG + radio_JGG), (posicionAltoFruta1_JGG + radio_JGG));
        rectComidaBasura1_JGG = new RectF((posicionAnchoComidaBasura1_JGG - radio_JGG /2),(posicionAltoComidaBasura1_JGG - radio_JGG /2),(posicionAnchoComidaBasura1_JGG + radio_JGG /2), (posicionAltoComidaBasura1_JGG + radio_JGG /2));
        rectComidaBasura2_JGG = new RectF((posicionAnchoComidaBasura2_JGG - radio_JGG),(posicionAltoComidaBasura2_JGG - radio_JGG),(posicionAnchoComidaBasura2_JGG + radio_JGG), (posicionAltoComidaBasura2_JGG + radio_JGG));

        //la fisica del elemento la colocamos junto el dibujo que representa el elemento
        // dibujas un rectangulo con fisica que cambia tamaño segun el radio de la imagen
        canvas.drawBitmap(bitmapCesta, null, rectCesta_JGG,cesta);
        canvas.drawBitmap(bitmapFruta1, null, rectFruta1_JGG,fruta1);
        canvas.drawBitmap(bitmapComidaBasura1, null, rectComidaBasura1_JGG,comidaBasura1);
        canvas.drawBitmap(bitmapComidaBasura1, null, rectComidaBasura2_JGG,comidaBasura2);
        // Est0s if genera de nuevo el elemento al estar su posicion mas elevada que la altura de la pantalla
        if (posicionAltoFruta1_JGG > alto_JGG) {
            posicionAltoFruta1_JGG = alto_JGG %99;
            posicionAnchoFruta1_JGG = random_JGG.nextInt(ancho_JGG); }
        if (posicionAltoComidaBasura1_JGG > alto_JGG) {
            posicionAltoComidaBasura1_JGG = alto_JGG %99;
            posicionAnchoComidaBasura1_JGG = random_JGG.nextInt(ancho_JGG); }

        if (posicionAltoComidaBasura2_JGG > alto_JGG) {
            posicionAltoComidaBasura2_JGG = alto_JGG %99;
            posicionAnchoComidaBasura2_JGG = random_JGG.nextInt(ancho_JGG); }
        // Calculo intersección
        //estos if genera resultado con el rectF al contactar las dos fisicas introducidad en el metodo
        //dentro del if seleccionamos los cambios deseados
        if (RectF.intersects(rectCesta_JGG, rectFruta1_JGG)) {
            puntOS_JGG += 1;
            //cuando llega al final se vuelve arriba
            posicionAltoFruta1_JGG = alto_JGG %99;
            //Cuando llega al final la coloca en otra posicion del ancho
            posicionAnchoFruta1_JGG = random_JGG.nextInt(ancho_JGG); }
        if (RectF.intersects(rectCesta_JGG, rectComidaBasura1_JGG)) {
            puntOS_JGG -= 5;
            posicionAltoComidaBasura1_JGG = alto_JGG %99;
            posicionAnchoComidaBasura1_JGG = random_JGG.nextInt(ancho_JGG); }
        if (RectF.intersects(rectCesta_JGG, rectComidaBasura2_JGG)) {
            puntOS_JGG -= 5;
            posicionAltoComidaBasura2_JGG = alto_JGG %99;
            posicionAnchoComidaBasura2_JGG = random_JGG.nextInt(ancho_JGG); } }}