package com.example.gatogerdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gatogerdoc.negocio.GatoNegocio;

public class MainActivity extends AppCompatActivity
{
    private boolean jugador;
    private int valores1[] = {R.id.button1,R.id.button2,R.id.button3,
            R.id.button4,R.id.button5, R.id.button6,
            R.id.button7, R.id.button8,R.id.button9};
    private int resultado[] = new int[valores1.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = null;
        jugador = false;
        for( int valor : valores1 )
        {
            button =  findViewById(valor);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (jugador)
                    {
                        ((Button)v).setText("x");
                        jugador = false;
                    }
                    else
                    {
                        ((Button)v).setText("O");
                        jugador = true;
                    }
                    ((Button)v).setEnabled( false );
                    resultado( );
                }
            });
        }
    }

    public void resultado( )
    {
        Button button = null;
        GatoNegocio gatoNegocio = null;
        for( int i = 0; i< valores1.length; i++ ) {
            button = findViewById(valores1[i]);
            if (!button.isEnabled()) {
                if ("x".equals(button.getText().toString())) {
                    resultado[i] = 1;
                } else {
                    resultado[i] = 2;
                }
            }
        }
        gatoNegocio = new GatoNegocio();
        if(gatoNegocio.isGanador1(resultado) )
        {

        }

        //TODO VA LA LOGICA DE NEGOCIO PARA VER SI YA HAY UN GANADOR O EMPATE
    }
}