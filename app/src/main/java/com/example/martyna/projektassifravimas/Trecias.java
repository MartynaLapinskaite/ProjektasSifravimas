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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sifravimas2);
    }

    public void btnM3(View v){

        EditText irasoma =(EditText)findViewById(R.id.irasoma);
        TextView rezultata = (TextView)findViewById(R.id.rezultata);

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


}
