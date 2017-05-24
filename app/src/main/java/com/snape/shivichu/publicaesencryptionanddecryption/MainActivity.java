package com.snape.shivichu.publicaesencryptionanddecryption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText eText;
    TextView tEncrypt,tDecrypt;
    Button bEncrypt,bDecrypt;
    String string;
    String decryptText,encryptText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eText = (EditText)findViewById(R.id.edt1);
        tEncrypt = (TextView)findViewById(R.id.txt_encrypted);
        tDecrypt = (TextView)findViewById(R.id.txt_decrypted);
        bEncrypt = (Button)findViewById(R.id.btn_encrypt);
        bDecrypt = (Button)findViewById(R.id.btn_decrypt);


        eText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence!=null)
                {
                    string = eText.getText().toString();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        bEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

                   encryptText = AESEncryption.encrypt(string);
                    tEncrypt.setText(encryptText);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        bDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    decryptText = AESEncryption.decrypt(encryptText);
                    tDecrypt.setText(decryptText);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
