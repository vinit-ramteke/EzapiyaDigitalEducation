package com.ezapiya.ezapiyadigitaleducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnlogin;
    EditText txtusername,txtpassword;
    TextView txterror;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin= findViewById(R.id.btnlogin);

        txtusername= findViewById(R.id.txtusername);
        txtpassword= findViewById(R.id.txtpassword);
        txterror= findViewById(R.id.txterror);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtusername.getText().toString().compareTo("")==0)
                {
                    txterror.setText("* Please Enter Username");
                }
                else {
                    if(txtpassword.getText().toString().compareTo("") == 0)
                    {
                        txterror.setText("* Please Enter Password");
                    }
                    else
                        {
                        if (txtusername.getText().toString().compareTo("vinit") == 0 && txtpassword.getText().toString().compareTo("april") == 0) {
                            // login
                            txterror.setText("");
                            Intent homeactivity = new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(homeactivity);
                            finish();

                        } else {

                            txterror.setText("* Invalid Username Or Password");
                        }
                    }
                }
            }
        });

    }
}