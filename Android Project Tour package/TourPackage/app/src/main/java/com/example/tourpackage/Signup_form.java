package com.example.tourpackage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_form extends AppCompatActivity {

    EditText txtNmae, txtUserName,txtEmail, txtPassword, txtConfirmPassword;
    Button btnRegister;
    ProgressBar barProgressBar;
    RadioGroup radioGroup;
    RadioButton radioGenderMale, radioGenderFemale;



    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    String Gender = "3rd Gender";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        getSupportActionBar().setTitle("Signup");
        getSupportActionBar().setTitle("SignUp form");

       txtNmae = (EditText) findViewById(R.id.txt_full_name);
        txtUserName = (EditText) findViewById(R.id.txt_user_name);
        txtEmail = (EditText) findViewById(R.id.txt_email);
        txtPassword = (EditText) findViewById(R.id.txt_password);
        txtConfirmPassword = (EditText) findViewById(R.id.txt_confirm_password);
        btnRegister = (Button) findViewById(R.id.btn_register);
        barProgressBar = (ProgressBar) findViewById(R.id.bar_progressBar);
        radioGenderMale =(RadioButton)findViewById(R.id.rMale);
        radioGenderFemale = (RadioButton) findViewById(R.id.rFemale);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        databaseReference = FirebaseDatabase.getInstance().getReference("UserData");






        firebaseAuth  = FirebaseAuth.getInstance();





//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View view) {
//                String name = txtNmae.getText().toString().trim();
//                String userName = txtUserName.getText().toString().trim();
//                String email = txtEmail.getText().toString().trim();
//                String password = txtPassword.getText().toString().trim();
//                String confirmPassword = txtConfirmPassword.getText().toString().trim();
//
//
//
//
//                if(TextUtils.isEmpty(name)){
//                    Toast.makeText( Signup_form.this, "Please enter your name", Toast.LENGTH_SHORT);
//                }
//                if(TextUtils.isEmpty(userName)){
//                    Toast.makeText( Signup_form.this, "Please enter your username", Toast.LENGTH_SHORT);
//                }
//                if(TextUtils.isEmpty(email)){
//                    Toast.makeText( Signup_form.this, "Please enter your email", Toast.LENGTH_SHORT);
//                }
//                if(TextUtils.isEmpty(password)){
//                    Toast.makeText( Signup_form.this, "Please enter your password", Toast.LENGTH_SHORT);
//                }
//                if(TextUtils.isEmpty(confirmPassword)){
//                    Toast.makeText( Signup_form.this, "Please confirm your password", Toast.LENGTH_SHORT);
//                }
//
//
//
//                if(password.length()<1){
//                    Toast.makeText( Signup_form.this, "Your password is too short", Toast.LENGTH_SHORT);
//                }
//
//
////                barProgressBar.setVisibility(View.VISIBLE);
//
//
//                if(password.equals(confirmPassword)){
//
//
//                    firebaseAuth.createUserWithEmailAndPassword(email, password)
//                            .addOnCompleteListener(Signup_form.this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//
////                                    barProgressBar.setVisibility(view.GONE);
//                                    if (task.isSuccessful()) {
//
//                                        Toast.makeText( Signup_form.this, "sucess", Toast.LENGTH_SHORT);
//
//
//
//                                    }
//                                    else {
//                                        Toast.makeText( Signup_form.this, "Authentication faild", Toast.LENGTH_SHORT);
//
//                                    }
//
//                                    // ...
//                                }
//                            });
//                }
//
//            }
//        });







        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name = txtNmae.getText().toString().trim();
                final String userName = txtUserName.getText().toString().trim();
                final String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String confirmPassword = txtConfirmPassword.getText().toString().trim();



                barProgressBar.setVisibility(View.VISIBLE);

                if (radioGenderMale.isChecked()){
                    Gender = "Male";
                }

                if (radioGenderFemale.isChecked()){
                    Gender = "Female";
                }

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Signup_form.this, "please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Signup_form.this, "please Enter Password", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(Signup_form.this, "please Enter Name", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(Signup_form.this, "please Enter user Name", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(Signup_form.this, "please Confirm Your Password", Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Signup_form.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                barProgressBar.setVisibility(view.GONE);
                                if (task.isSuccessful()) {
                                    UserData information = new UserData(
                                            name,userName,email,Gender
                                    );

                                    FirebaseDatabase .getInstance().getReference("UserData")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(information).addOnCanceledListener(new OnCanceledListener() {
                                        @Override
                                        public void onCanceled() {
                                            Toast.makeText(Signup_form.this, "Done", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));


                                } else {

                                }

                                // ...
                            }
                        });



            }
        });




    }
}
