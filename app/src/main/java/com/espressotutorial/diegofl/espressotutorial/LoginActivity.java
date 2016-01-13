package com.espressotutorial.diegofl.espressotutorial;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText mEditTextUser;
    EditText mEditTextPassword;
    Button mButtonLogin;
    Button mButtonNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();
    }

    private void initViews(){
        mEditTextUser = (EditText)findViewById(R.id.editTextUser);
        mEditTextPassword = (EditText)findViewById(R.id.editTextPassword);
        mButtonLogin = (Button)findViewById(R.id.buttonLogin);
        mButtonLogin.setOnClickListener(onClickListenerLogin);
        mButtonNewUser = (Button)findViewById(R.id.buttonRegister);
        mButtonNewUser.setOnClickListener(onClickListenerNewUser);
    }

    View.OnClickListener onClickListenerLogin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mEditTextUser.getText().toString().isEmpty() || mEditTextPassword.getText().toString().isEmpty()){
                showMessage(getResources().getString(R.string.info), getResources().getString(R.string.login_invalid));
            }else{
                showMessage(getResources().getString(R.string.info), getResources().getString(R.string.login_successful));
            }
        }
    };

    View.OnClickListener onClickListenerNewUser = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentNewUser = new Intent(LoginActivity.this, NewUserActivity.class);
            startActivity(intentNewUser);
        }
    };

    private void showMessage(String title, String message){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
