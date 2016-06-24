package com.injani.salestracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.dd.processbutton.iml.ActionProcessButton;
import com.injani.salestracker.library.SessionManager;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by andi on 6/20/2016.
 */
public class ForgotActivity extends AppCompatActivity {
    SessionManager session;
    @InjectView(R.id.input_email)
    EditText _emailText;
    ActionProcessButton btn_forgot;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        ButterKnife.inject(this);
        // Session manager
        session = new SessionManager(getApplicationContext());

        _emailText = (EditText) findViewById(R.id.input_email);
        btn_forgot = (ActionProcessButton) findViewById(R.id.btn_forgot);



        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate()) {

                    // TODO: Implement your own signup logic here.
                    HashMap<String, String> data = new HashMap<String, String>();
                    data.put("email", _emailText.getText().toString());

                  /*  ForgotTask task = new ForgotTask(ForgotActivity.this, data,btn_forgot,_emailText);
                    task.execute();*/
                }

            }
        });


        // Check if user is already logged in or not

    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        return valid;
    }
}

