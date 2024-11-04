package com.example.tareaswitch;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Inicializar el switch
        Switch switchButton = findViewById(R.id.switch1);
        // Inicializar la imagen
        ImageView imageView = findViewById(R.id.imageView);


        switchButton.setChecked(false);
        switchButton.setText("Desactivado");
        switchButton.setTextColor(Color.BLACK);
        imageView.setVisibility(ImageView.INVISIBLE);


        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Cuando esta Activado
                    buttonView.setText("Activado");
                    buttonView.setTextColor(Color.RED);
                    imageView.setVisibility(ImageView.VISIBLE);
                } else {
                    // Cuando está Desactivado
                    buttonView.setText("Desactivado");
                    buttonView.setTextColor(Color.BLACK);
                    imageView.setVisibility(ImageView.INVISIBLE);
                }
            }
        });
    }
}
