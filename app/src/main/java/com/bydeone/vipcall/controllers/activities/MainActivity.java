package com.bydeone.vipcall.controllers.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bydeone.vipcall.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button butConnexion;
    private EditText edtvUserName, edtvPassWord;
    private TextView tvSignUp;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        this.configureEmailLogin();
        this.configurePasswordLogin();
        this.configureConnexion();
        this.configureUserCreation();
    }

    private void configureEmailLogin(){
        this.edtvUserName = (EditText) findViewById(R.id.edtvUserName);
    }

    private void configurePasswordLogin(){
        this.edtvPassWord = (EditText) findViewById(R.id.edtvPassWord);
    }

    private void configureConnexion(){
        this.butConnexion = (Button)findViewById(R.id.butConnexion);
        this.butConnexion.setOnClickListener(this);
    }
    private void configureUserCreation(){
        this.tvSignUp = (TextView)findViewById(R.id.tvSignUp);
        this.tvSignUp.setOnClickListener(this);
    }

    private void userConnexion() {
        String email = edtvUserName.getText().toString().trim();
        String password = edtvPassWord.getText().toString().trim();


        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "SVP entrer votre Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "SVP entrer votre Mot de passe", Toast.LENGTH_SHORT).show();
            return;
        }
        // if validate ok
        progressDialog.setMessage("Connexion encours...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            finish();
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Connexion échouée!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == butConnexion){
            userConnexion();
        }else if (v == tvSignUp){
            finish();
            startActivity(new Intent(MainActivity.this, NewCompteActivity.class));
        }
    }
}
