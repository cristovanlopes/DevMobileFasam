package com.example.exx3;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenha o LinearLayout do layout
        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        // Array de informações fictícias
        String[] countriesAndCapitals = {
                "Brasil - Brasília",
                "Estados Unidos - Washington D.C.",
                "França - Paris",
                "Japão - Tóquio",
                "Alemanha - Berlim",
                "Itália - Roma",
                "China - Pequim",
                "Índia - Nova Deli"
        };

        // Itera sobre o array para adicionar TextViews dinamicamente
        for (String item : countriesAndCapitals) {
            TextView textView = new TextView(this);
            textView.setText(item);
            linearLayout.addView(textView);
        }
    }
}
