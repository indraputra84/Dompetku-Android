package com.example.dompetku.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dompetku.R;
import com.example.dompetku.Database.SqliteHelper;
import com.example.dompetku.Database.User;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextUsername,editTextEmail,editTextPassword;
    TextInputLayout textInputLayoutUsername,textInputLayoutEmail,textInputLayoutPassword;

    Button buttonRegister;

    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sqliteHelper = new SqliteHelper(this);
        initTextViewLogin();
        initViews();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    String Username = editTextUsername.getText().toString();
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    if (!sqliteHelper.isEmailExists(Email)){
                        sqliteHelper.addUser(new User(null,Username,Email,Password));
                        Snackbar.make(buttonRegister,"User create successfully!! please login",Snackbar.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, Snackbar.LENGTH_LONG);
                    }else{
                        Snackbar.make(buttonRegister,"User is already exists with same email",Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void initTextViewLogin(){
        TextView textView = (TextView) findViewById(R.id.textViewLogin);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initViews(){
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);

        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutUsername = (TextInputLayout) findViewById(R.id.textInputLayoutUsername);

        buttonRegister = (Button) findViewById(R.id.buttonRegisters);
    }

    public boolean validate(){
        boolean valid = false;
        String Username = editTextUsername.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        if (Username.isEmpty()){
            valid = false;
            textInputLayoutUsername.setError("Please enter valid username!!");
        }else{
            if(Username.length() > 5){
                valid = true;
                textInputLayoutUsername.setError(null);
            }
            else{
                valid = false;
                textInputLayoutUsername.setError("Username is to short!!");
            }
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            valid = false;
            textInputLayoutEmail.setError("Please enter valid email!!");
        }else{
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        if (Password.isEmpty()){
            valid = false;
            textInputLayoutPassword.setError("Please enter valid Password!!");
        }else{
            if(Password.length() > 5){
                valid = true;
                textInputLayoutPassword.setError(null);
            }
            else{
                valid = false;
                textInputLayoutPassword.setError("Password is to short!!");
            }
        }

        return valid;
    }
}
