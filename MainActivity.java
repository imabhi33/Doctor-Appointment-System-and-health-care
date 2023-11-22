package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Uname, pass;
    Button btn;
    TextView tv,al;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uname = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.password);
        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.sign);
        al=findViewById(R.id.adminlogin);
        al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivty.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=Uname.getText().toString();
                String password=pass.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if (username.length()==0||password.length()==0){
                    Toast.makeText(getApplicationContext(), "Plz fill all the details", Toast.LENGTH_SHORT).show();
                }else {
                    if (db.login(username,password) == 1) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences= getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();
                        startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    } else {

                        Toast.makeText(getApplicationContext(), "Invalid Username Or Password", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });

    }
}


