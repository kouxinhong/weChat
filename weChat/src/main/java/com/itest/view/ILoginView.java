package com.itest.view;

/**
 * Created by Administrator on 2016/3/12.
 */
public interface ILoginView {

    void clearEditText();

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    String getUsername();

    String getPassword();

    void loginSuccess();
}
