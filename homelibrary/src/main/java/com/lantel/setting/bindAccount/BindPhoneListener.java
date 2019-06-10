package com.lantel.setting.bindAccount;

public interface BindPhoneListener{
    void sendVerifyCode(String phone);

    void bind(String phone,String verifyCode);
}
