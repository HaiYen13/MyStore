package com.yenvth.mystore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.yenvth.mystore.main.MainActivity;

public class LoginActivity extends AppCompatActivity {
    ImageView imvSignUpBack;
    TextView tvForgotPass;
    Button btnLogin;
    EditText edtEmail;
    EditText edtPassword;
    CardView cardViewGoogle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initAction();
//        ed.setVisibility(View.VISIBLE);


    }

    private void initView() {
        imvSignUpBack = findViewById(R.id.sign_up_back_imv);
        tvForgotPass = findViewById(R.id.login_forgot_password_tv);
        btnLogin = findViewById(R.id.login_btn);
        edtEmail = findViewById(R.id.email_edt);
        edtPassword = findViewById(R.id.password_edt);
        cardViewGoogle = findViewById(R.id.card_view_google_login);
    }

    private void initAction() {
        tvForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
        imvSignUpBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                acountVetification(email, password);
            }
        });

        cardViewGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();

            }
        });
    }

    private void acountVetification(String email, String password) {
        if (email.equals("HaiYen") && password.equals("123456")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "tai khoan khong chinh xac", Toast.LENGTH_SHORT).show();
        }
    }
}
