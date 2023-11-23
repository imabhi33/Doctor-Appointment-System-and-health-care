package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivty extends AppCompatActivity {
    EditText ett1,ett2;
    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activty);
        ett1=findViewById(R.id.et1);
        ett2=findViewById(R.id.et2);
        log=findViewById(R.id.b1);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String U ="Abhijit";
                String P="Mishra";
                if ((ett1.getText().toString().equals(U)) && (ett2.getText().toString().equals(P))) {
                    Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivty.this,AdminHomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(),"Login Faild",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}