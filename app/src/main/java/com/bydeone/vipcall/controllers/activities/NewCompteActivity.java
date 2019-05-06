package com.bydeone.vipcall.controllers.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bydeone.vipcall.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NewCompteActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int PICK_IMAGE_REQUEST = 99;
    private EditText edtvEmailLogin;
    private EditText edtvPasswordLogin;
    private EditText edtvNameLogin;
    private EditText edtvTelephoneLogin;
    private EditText edtvConfirmPasswordLogin;
    private CheckBox chbAcceptConditionLogin;
    private Button btCancel;
    private Button btSave;
    private Button btAddUserPicture;
    private ImageView imUserProfil;
    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_compte);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        edtvEmailLogin = (EditText) findViewById(R.id.edtvEmailLogin);
        edtvPasswordLogin = (EditText) findViewById(R.id.edtvPasswordLogin);
        edtvConfirmPasswordLogin = (EditText) findViewById(R.id.edtvConfirmPasswordLogin);
        edtvNameLogin = (EditText) findViewById(R.id.edtvNameLogin);
        edtvTelephoneLogin = (EditText) findViewById(R.id.edtvTelephoneLogin);
        chbAcceptConditionLogin = (CheckBox) findViewById(R.id.chbAcceptConditionLogin);
        btCancel = (Button) findViewById(R.id.btCancel);
        btCancel.setOnClickListener(this);
        btSave = (Button) findViewById(R.id.btSave);
        btSave.setOnClickListener(this);
        btAddUserPicture = (Button) findViewById(R.id.btAddUserPicture);
        btAddUserPicture.setOnClickListener(this);
        imUserProfil = (ImageView) findViewById(R.id.imUserProfil);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }

    @Override
    public void onClick(View v) {

        if(v == btCancel){
            finish();
            startActivity(new Intent(NewCompteActivity.this, MainActivity.class));
        }else if (v == btSave){

            String email = edtvEmailLogin.getText().toString().trim();
            String password = edtvPasswordLogin.getText().toString().trim();
            String confirmPassword = edtvConfirmPasswordLogin.getText().toString().trim();
            String name = edtvNameLogin.getText().toString().trim();
            String telphone = edtvTelephoneLogin.getText().toString().trim();

            if (TextUtils.isEmpty(email)){
                Toast.makeText(this, "SVP entrer votre Email", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(password)){
                Toast.makeText(this, "SVP entrer votre mot de passe", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(confirmPassword)){
                Toast.makeText(this, "Confirme ton mot de passe", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(name)){
                Toast.makeText(this, "SVP entrer votre Nom", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(telphone)){
                Toast.makeText(this, "SVP entrer votre numero de téléphone", Toast.LENGTH_SHORT).show();
                return;
            }

            /*if (password != confirmPassword){
                Toast.makeText(this, "Les mots de passe ne sont pas identiques", Toast.LENGTH_SHORT).show();
                return;
            }*/

            // If validate OK
            progressDialog.setMessage("Creation du compte encours...");
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(NewCompteActivity.this, "Création de compte réussie", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(NewCompteActivity.this, MainActivity.class));
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(NewCompteActivity.this, "Création de compte échoué", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }else if (v == btAddUserPicture){
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "select image"), PICK_IMAGE_REQUEST);
        }
    }

}
