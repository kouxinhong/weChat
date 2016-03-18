package com.itest.presenter;

/**
 * Created by Administrator on 2016/3/12.
 */
public interface ILoginPresenter {

    void doLogin(String username, String password);

    void clear();

    void onDestroy();
}
