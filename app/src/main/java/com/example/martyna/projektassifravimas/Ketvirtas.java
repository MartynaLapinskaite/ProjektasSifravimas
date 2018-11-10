package com.example.martyna.projektassifravimas;

import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.Map;


public class Ketvirtas extends AppCompatActivity {

    EditText irasom;
    TextView rezultat;

    Button mygtuk;
    Button issifravim;
    Button co;
    String rez;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sifravimas3);

        irasom=(EditText)findViewById(R.id.irasom);
        rezultat=(TextView)findViewById(R.id.rezultat);

        mygtuk = (Button) findViewById(R.id.mygtuk);
        issifravim = (Button) findViewById(R.id.issifravim);
        irasom.addTextChangedListener(loginTextWatcher);

        co=(Button)findViewById(R.id.co);
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rez = rezultat.getText().toString();
                irasom.setText(rez);
            }
        });
    }

    public void encrypt(View v){
        byte[] base64Data=irasom.getText().toString().getBytes();
        String base64Str ="";

        try{
            base64Str = base64.encryptBASE64(base64Data);

        }catch (Exception e){
            Toast.makeText(Ketvirtas.this, "Klaida", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        rezultat.setText(base64Str);
    }

    public void decrypt(View v){
        String base64Str=irasom.getText().toString();
        byte[] base64Byte = null;

        try{
            base64Byte=base64.decryptBASE64(base64Str);
        }catch (Exception e){
            Toast.makeText(Ketvirtas.this, "Klaida", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        String output = new String(base64Byte);
        rezultat.setText(output);
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String irasomas1 = irasom.getText().toString().trim();

            mygtuk.setEnabled(!irasomas1.isEmpty());
            issifravim.setEnabled(!irasomas1.isEmpty());
            co.setEnabled(!irasomas1.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };


}
