package com.example.tourpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class Login_form extends AppCompatActivity {





    //for facebook login
    private LoginButton loginButton;
    private CircleImageView circleImageView;
    private TextView txtName,txtEmail;
    private CallbackManager callbackManager;
    private String fb_id;







    //for firebase
    private FirebaseAuth firebaseAuth;
    EditText txtEmail1, txtPassword;
    Button btn_Login;


    //for firebase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login");

        txtEmail1 = (EditText)findViewById(R.id.txt_email1);
        txtPassword = (EditText)findViewById(R.id.txt_password1);
        btn_Login = (Button)findViewById(R.id.btn_login);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_Login.setOnClickListener(new View.OnClickListener() {



            @Override

            public void onClick(View view) {
                String email = txtEmail1.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    Toast.makeText( Login_form.this, "Please enter your email", Toast.LENGTH_SHORT);
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText( Login_form.this, "Please enter your password", Toast.LENGTH_SHORT);
                }


                if(password.length()<4){
                    Toast.makeText( Login_form.this, "Your password is too short", Toast.LENGTH_SHORT);
                }



                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login_form.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login_form.this, "sucessfull", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                                } else {
                                    Toast.makeText(Login_form.this, "Wrong email and password", Toast.LENGTH_SHORT).show();

                                }

                            }
                        });

            }
        });





        //for facebook login
        loginButton = findViewById(R.id.login_button);
        txtName = findViewById(R.id.profile_name);
        txtEmail = findViewById(R.id.profile_email);
        circleImageView = findViewById(R.id.profile_pic);

        callbackManager = CallbackManager.Factory.create();


        loginButton.setReadPermissions(Arrays.asList("email","public_profile"));
        checkLoginStatus();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Toast.makeText(Login_form.this, "sucess", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancel() {
                Toast.makeText(Login_form.this, "cencell", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(Login_form.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });


    }


    //for go to signup xml. not a part of facebook login or anything
    public void btn_signupForm(View view) {
        startActivity(new Intent(getApplicationContext(),Signup_form.class));
    }



    //for facebook activity result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    //for facebook token tracker
    AccessTokenTracker tokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken)
        {
            if(currentAccessToken==null)
            {
                txtName.setText("");
                txtEmail.setText("");
                circleImageView.setImageResource(0);
                Toast.makeText(Login_form.this,"User Logged out",Toast.LENGTH_LONG).show();
            }
            else
                loadUserProfile(currentAccessToken);
        }
    };





    //for facebook access token
    private void loadUserProfile(AccessToken newAccessToken)
    {
        GraphRequest request = GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response)
            {
                try {
                    String first_name = object.getString("first_name");
                    String last_name = object.getString("last_name");
                    String email = object.getString("email");
                    String id = object.getString("id");
                    String image_url = "https://graph.facebook.com/"+id+ "/picture?type=normal";

                    txtEmail.setText(email);
                    txtName.setText(first_name +" "+last_name);
                    fb_id = id;
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.dontAnimate();

                    Glide.with(Login_form.this).load(image_url).into(circleImageView);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });



        Bundle parameters = new Bundle();
        parameters.putString("fields","first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();

    }


    private void checkLoginStatus()
    {
        if(AccessToken.getCurrentAccessToken()!=null)
        {
            loadUserProfile(AccessToken.getCurrentAccessToken());
        }
    }


    public void btn_notejs_login(View view) {
        startActivity(new Intent(getApplicationContext(),andojs.class));
    }
}
