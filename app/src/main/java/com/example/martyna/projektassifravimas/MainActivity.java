package com.example.martyna.projektassifravimas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button aes;
    private Button rsaa;
    private Button md5;
    private Button base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aes = (Button) findViewById(R.id.aes);
        aes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPirmas();
            }
        });

        rsaa = (Button)findViewById(R.id.rsaa);
        rsaa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAntras();
            }
        });

        md5 = (Button)findViewById(R.id.md5);
        md5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openTrecias();
            }
        });

        base = (Button)findViewById(R.id.base);
        base.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openKetvirtas();
            }
        });

    }
    public void openPirmas(){
        Intent intent = new Intent(this, Pirmas.class);
        startActivity(intent);
    }

    public void openAntras(){
        Intent intent = new Intent(this, Antras.class);
        startActivity(intent);
    }

    public void openTrecias(){
        Intent intent = new Intent(this, Trecias.class);
        startActivity(intent);
    }

    public void openKetvirtas(){
        Intent intent = new Intent(this, Ketvirtas.class);
        startActivity(intent);
    }
}