package com.ekomartantoh.tokoonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi Variabel
    EditText edtUser, edtPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Membuat object
        edtUser = (EditText) findViewById(R.id.user);
        edtPass = (EditText) findViewById(R.id.pass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        //Eksekusi login
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(edtUser.getText().toString().equals("")){
                    edtUser.setError("Masukan User Anda");
                }else if(edtPass.getText().toString().equals("")){
                    edtPass.setError("Masukan Password Anda");
                }else{
                    if(edtUser.getText().toString().equals("eko")&&
                            edtPass.getText().toString().equals("123")){
                        Intent nextAcivity = new Intent(getApplicationContext(), Menu.class);
                        startActivity(nextAcivity);
                    }else {
                        Toast.makeText(getApplicationContext(), "User atau Password anda salah!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
