package com.example.jogodado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView dado;
    private EditText editTextNumero;
    private TextView tvResultado;

    private int[] numerosDoDado = {
            R.drawable.dadoum,
            R.drawable.dadodois,
            R.drawable.dadotres,
            R.drawable.dadoquatro,
            R.drawable.dadocinco,
            R.drawable.dadoseis
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dado = findViewById(R.id.dado);
        tvResultado = findViewById(R.id.tvResultado);
        editTextNumero = findViewById(R.id.editTextNumero);


        dado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int numerosAleatorios = new Random().nextInt(numerosDoDado.length);
                //int numero = Integer.parseInt(editTextNumero.getText().toString());
                String pegarNumero = editTextNumero.getText().toString();

                if (pegarNumero.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor, digite um número", Toast.LENGTH_SHORT).show();
                } else {

                    int numero = Integer.parseInt(pegarNumero);

                    if (numero < 1 || numero > 6) {
                        Toast.makeText(getApplicationContext(), "Digite um Nº de 1 a 6", Toast.LENGTH_SHORT).show();
                    } else {

                        dado.setImageResource(numerosDoDado[numerosAleatorios]);

                        if ((numerosAleatorios + 1) == numero) {
                            tvResultado.setText("\nParabéns! Você acertou!");
                        } else {
                            tvResultado.setText("\nVocê errou! Tente novamente");
                        }
                    }


                }
            }
        });
    }
}