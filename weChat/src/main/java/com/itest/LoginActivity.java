package com.itest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.itest.presenter.ILoginPresenter;
import com.itest.presenter.LoginPresenter;
import com.itest.view.ILoginView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 这是一个mvp的例子
 */
public class LoginActivity extends FragmentActivity implements ILoginView {

    @InjectView(R.id.et_username)
    EditText etUsername;
    @InjectView(R.id.et_password)
    EditText etPassword;
    @InjectView(R.id.bt_login)
    Button btLogin;
    @InjectView(R.id.bt_clear)
    Button btClear;
    @InjectView(R.id.progress)
    ProgressBar progress;

    private ILoginPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        mLoginPresenter = new LoginPresenter(this);
    }


    @OnClick({R.id.bt_login,R.id.bt_clear})
    public void onClick(View view){

        switch (view.getId()){
            case R.id.bt_login:
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                mLoginPresenter.doLogin(username,password);
                break;
            case R.id.bt_clear:
                mLoginPresenter.clear();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void clearEditText() {

        etUsername.setText("");
        etPassword.setText("");
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {

        etUsername.setText("username error");
    }

    @Override
    public void setPasswordError() {

        etPassword.setText("password error");
    }

    @Override
    public String getUsername() {

       return etUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void loginSuccess() {

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Login success",Toast.LENGTH_LONG);
    }

}
