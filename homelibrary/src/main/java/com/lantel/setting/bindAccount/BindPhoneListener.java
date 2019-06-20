package com.lantel.setting.bindAccount;

public interface BindPhoneListener{
    void sendVerifyCode(String phone, BindAccountDialog bindAccountDialog);

    void bind(String phone,String verifyCode);
}
