package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        t1=findViewById(R.id.editTextTextPassword);
        t2=findViewById(R.id.editTextTextPassword2);
        t3=findViewById(R.id.editTextTextPassword3);
        t4=findViewById(R.id.editTextTextPassword4);
        t5=findViewById(R.id.editTextTextPassword5);
        update=findViewById(R.id.updt);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                SharedPreferences sharedPreferences= getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username= sharedPreferences.getString("username","").toString();
                Toast.makeText(getApplicationContext(), "Wellcome"+username, Toast.LENGTH_SHORT).show();

                db.profile(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString(),t5.getText().toString());

                Toast.makeText(getApplicationContext(), "Your appointment is done successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProfileActivity.this,HomeActivity.class));
            }


        });



    }
}