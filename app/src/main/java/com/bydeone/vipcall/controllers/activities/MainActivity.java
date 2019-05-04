package com.bydeone.vipcall.controllers.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bydeone.vipcall.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button butConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butConnexion = (Button)findViewById(R.id.butConnexion);
        butConnexion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == butConnexion){
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }
    }
}
