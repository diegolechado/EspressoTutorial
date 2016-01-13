package com.espressotutorial.diegofl.espressotutorial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class NewUserActivity extends AppCompatActivity {

    EditText mEditTextUser;
    EditText mEditTextPassword;
    EditText mEditTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabRegister);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mEditTextUser.getText().toString().isEmpty() || mEditTextPassword.getText().toString().isEmpty()
                        || mEditTextEmail.getText().toString().isEmpty()){
                    Snackbar.make(view, getResources().getString(R.string.register_fail), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    Snackbar.make(view, getResources().getString(R.string.register_success), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        initViews();
    }

    private void initViews(){
        mEditTextUser = (EditText)findViewById(R.id.editTexNewtUser);
        mEditTextPassword = (EditText)findViewById(R.id.editTextNewPassword);
        mEditTextEmail = (EditText)findViewById(R.id.editTextNewEmail);
    }

}
