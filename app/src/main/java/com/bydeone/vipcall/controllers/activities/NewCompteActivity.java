package com.bydeone.vipcall.controllers.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.bydeone.vipcall.R;
import com.google.firebase.auth.FirebaseAuth;

public class NewCompteActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtvEmailLogin;
    private EditText edtvPasswordLogin;
    private EditText edtvNameLogin;
    private EditText edtvTelephoneLogin;
    private EditText edtvConfirmPasswordLogin;
    private CheckBox chbAcceptConditionLogin;
    private Button btCancel;
    private Button btSave;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_compte);

        this.configureEmailLogin();
        this.configurePasswordLogin();
        this.configureNameLogin();
        this.configureTelephoneLogin();
        this.configureChecbooxAccept();
        this.configureBoutonCancel();
        this.configureBoutonSave();
    }

    private void configureEmailLogin(){
        this.edtvEmailLogin = (EditText) findViewById(R.id.edtvEmailLogin);
    }

    private void configurePasswordLogin(){
        this.edtvPasswordLogin = (EditText) findViewById(R.id.edtvPasswordLogin);
        this.edtvConfirmPasswordLogin = (EditText) findViewById(R.id.edtvConfirmPasswordLogin);
    }

    private void configureNameLogin(){
        this.edtvNameLogin = (EditText) findViewById(R.id.edtvNameLogin);
    }

    private void configureTelephoneLogin(){
        this.edtvTelephoneLogin = (EditText) findViewById(R.id.edtvTelephoneLogin);
    }

    private void configureChecbooxAccept(){
        this.chbAcceptConditionLogin = (CheckBox) findViewById(R.id.chbAcceptConditionLogin);
    }

    private void configureBoutonCancel(){
        this.btCancel = (Button) findViewById(R.id.btCancel);
        this.btCancel.setOnClickListener(this);
    }

    private void configureBoutonSave(){
        this.btSave = (Button) findViewById(R.id.btSave);
        this.btSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == btCancel){
            finish();
            startActivity(new Intent(NewCompteActivity.this, MainActivity.class));
        }else if (v == btSave){

        }
    }
}
