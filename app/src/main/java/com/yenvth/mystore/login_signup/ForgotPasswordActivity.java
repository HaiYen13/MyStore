package com.yenvth.mystore.login_signup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.yenvth.mystore.R;

public class ForgotPasswordActivity extends AppCompatActivity {
    ImageView imgLoginBack;
    TextView tvNotValidEmail;
    EditText edtForgotEmail;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        init();
        initAction();
    }
    private void init(){
        imgLoginBack = findViewById(R.id.login_back_imv);
        tvNotValidEmail = findViewById(R.id.not_valid_email_tv);
        edtForgotEmail = findViewById(R.id.forgot_email_edt);

    }
    private void initAction(){
        imgLoginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        edtForgotEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().contains("@")){
                    edtForgotEmail.setCompoundDrawables(null, null, null, null);
                    tvNotValidEmail.setVisibility(View.GONE);
                }else{
                    edtForgotEmail.setCompoundDrawablesWithIntrinsicBounds(null, null, ResourcesCompat.getDrawable(getResources(), R.drawable.ic_close, null), null);
                    tvNotValidEmail.setVisibility(View.VISIBLE);
                }

            }
        });
    }

}
