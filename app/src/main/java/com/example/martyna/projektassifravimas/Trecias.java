package com.example.martyna.projektassifravimas;


import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class Trecias extends AppCompatActivity {

    EditText irasoma;
    TextView rezultata;

    Button mygtuka;
    Button issifravima;
    Button cop;
    String rez;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sifravimas2);

        mygtuka = (Button) findViewById(R.id.mygtuka);
        issifravima = (Button) findViewById(R.id.issifravima);
        irasoma =(EditText)findViewById(R.id.irasoma);
        rezultata = (TextView)findViewById(R.id.rezultata);

        irasoma.addTextChangedListener(loginTextWatcher);



        cop=(Button)findViewById(R.id.cop);
        cop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rez = rezultata.getText().toString();
                irasoma.setText(rez);
            }
        });
    }

    public void btnMD5(View v){

        byte[] md5Input = irasoma.getText().toString().getBytes();
        BigInteger md5Data = null;

        try {
            md5Data = new BigInteger(1, md5.encryptMD5(md5Input));
        }catch (Exception e){
            e.printStackTrace();
        }

        String md5Str = md5Data.toString(16);
        if(md5Str.length()<32){
            md5Str= 0+md5Str;
        }

        rezultata.setText(md5Str);

    }



    public void btnnMD5(View v){

        byte[] md5Input = irasoma.getText().toString().getBytes();
        BigInteger md5Data = null;



        try {
            md5Data = new BigInteger(1, md5.decryptMD5(md5Input));
        }catch (Exception e){
            e.printStackTrace();
        }

        String md5Str = md5Data.toString(16);
        if(md5Str.length()<32){
            md5Str= 0+md5Str;
        }

        rezultata.setText(md5Str);

    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String irasomas1 = irasoma.getText().toString().trim();

            mygtuka.setEnabled(!irasomas1.isEmpty());
            issifravima.setEnabled(!irasomas1.isEmpty());
            cop.setEnabled(!irasomas1.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };


}
