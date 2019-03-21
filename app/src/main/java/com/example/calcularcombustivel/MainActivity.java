package com.example.calcularcombustivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private SeekBar alcoolSeekBar;

    private SeekBar gasolinaSeekBar;

    private TextView gasolinaValor;

    private TextView alcoolValor;

    private TextView validador;

    private double valorGasolina;

    private double valorAlcool;

    private double validar;

//    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //      INFLANDO A VIEW
        setContentView(R.layout.activity_main);
//      INICIANDO OS COMPONENTES VISUAIS DE INTERESSE
        gasolinaSeekBar = findViewById(R.id.gasolina);
        gasolinaValor = findViewById(R.id.gasolinaValor);

        alcoolSeekBar = findViewById(R.id.alcool);
        alcoolValor = findViewById(R.id.alcoolValor);

        validador = findViewById(R.id.validador);
//        img = findViewById(R.id.image);

        alcoolSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valorAlcool = (float)progress/10.0;
                alcoolValor.setText(String.valueOf(valorAlcool));
                validar = valorAlcool/valorGasolina;
                if (validar>=0.7){
                    validador.setText("ETANOL");
//                    img.setImageResource(R.drawable.alcool);
                }else{
                    validador.setText("GASOLINA");
//                    img.setImageResource(R.drawable.gasolina);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        gasolinaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valorGasolina = (float)progress/10.0;
                gasolinaValor.setText(String.valueOf(valorGasolina));

                if (validar>=0.7){
                    validador.setText("ETANOL");
//                    img.setImageResource(R.drawable.alcool);
                }else{
                    validador.setText("GASOLINA");
//                    img.setImageResource(R.drawable.gasolina);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

}
