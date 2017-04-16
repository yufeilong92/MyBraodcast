package com.example.dell.mybraodcast;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_userNam;
    private EditText et_password;
    private Button btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et_userNam = (EditText) findViewById(R.id.et_userNam);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_Login = (Button) findViewById(R.id.btn_Login);

        btn_Login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Login:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String userNam = et_userNam.getText().toString().trim();
        if (TextUtils.isEmpty(userNam)) {
            Toast.makeText(this, "userNam不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = et_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
       if (userNam.equals("123")&&password.equals("123")){
           MainActivity.startInten(this,userNam,password);
       }

    }
}
