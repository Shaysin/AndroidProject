package com.example.abrivard1.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent intent = new Intent(this, DistrictActivity.class);
        final Bundle extra = new Bundle();

        ImageView imgV =(ImageView) findViewById(R.id.loginButon);
        imgV.setClickable(true);
        imgV.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText login = (EditText) findViewById(R.id.login);
                EditText pass = (EditText) findViewById(R.id.pass);

                Toast WIN = Toast.makeText(getApplicationContext(),
                        R.string.success,Toast.LENGTH_SHORT);

                Toast FAIL = Toast.makeText(getApplicationContext(),
                        R.string.fail,Toast.LENGTH_SHORT);

                WIN.setGravity(Gravity.CENTER,0,100);
                FAIL.setGravity(Gravity.CENTER,0,100);

                if (String.valueOf(login.getText()).equals("admin")
                        && String.valueOf(pass.getText()).equals("password")) {
                    WIN.show();

                    extra.putString("pseudo", login.getText().toString());
                    intent.putExtras(extra);
                    startActivity(intent);
                } else FAIL.show();
            }
        });
    }

}
