package com.example.martyna.projektassifravimas;

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


public class Antras extends AppCompatActivity {

    private EditText irasomass;
    private TextView rezultatass;
    private String publicKey= "";
    private String privateKey= "";
    private byte[] encodeData=null;
    Button mygtukass;
    Button issifravimass;
    String rez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sifravimas1);

        irasomass = (EditText) findViewById(R.id.irasomass);
        rezultatass = (TextView) findViewById(R.id.rezultatass);

        try{
            Map<String, Object> keyMap=rsa.initKey();
            publicKey=rsa.getPublicKey(keyMap);
            privateKey=rsa.getPrivateKey(keyMap);
        } catch (Exception e){
            e.printStackTrace();
        }

        irasomass.addTextChangedListener(loginTextWatcher);


        mygtukass = (Button) findViewById(R.id.mygtukass);
        issifravimass = (Button) findViewById(R.id.issifravimass);

    }

    public void encrypt(View v){
        byte[] rsaData = irasomass.getText().toString().getBytes();

        try {
            encodeData = rsa.encryptByPublicKey(rsaData, getPublicKey());
            String encodeStr = new BigInteger(1, encodeData).toString();
            rezultatass.setText(encodeStr);
        }catch (Exception e){
            Toast.makeText(Antras.this, "Klaida", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void decrypt(View v){

        try {
            byte[] decodeData = rsa.encryptByPrivateKey(encodeData, getPrivateKey());
            String decodeStr = new String(decodeData);
            rezultatass.setText(decodeStr);
        }catch (Exception e){
            Toast.makeText(Antras.this, "Klaida", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public String getPublicKey(){
        return publicKey;
    }

    public String getPrivateKey(){
        return privateKey;
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String irasomas1 = irasomass.getText().toString().trim();

            mygtukass.setEnabled(!irasomas1.isEmpty());
            issifravimass.setEnabled(!irasomas1.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

}
