package com.example.bicicletariabikecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class aro12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aro12);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setImageDrawable(getDrawable(R.drawable.principal));

    }
}