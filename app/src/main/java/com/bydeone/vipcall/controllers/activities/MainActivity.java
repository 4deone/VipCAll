package com.bydeone.vipcall.controllers.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bydeone.vipcall.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button butConnexion;
    private TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butConnexion = (Button)findViewById(R.id.butConnexion);
        butConnexion.setOnClickListener(this);

        tvSignUp = (TextView)findViewById(R.id.tvSignUp);
        tvSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == butConnexion){
            finish();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }else if (v == tvSignUp){
            finish();
            startActivity(new Intent(MainActivity.this, NewCompteActivity.class));
        }
    }
}
