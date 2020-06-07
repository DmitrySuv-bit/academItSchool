package model;

import com.jcraft.jsch.UserInfo;

public class MyUserInfo implements UserInfo {
    private String password;

    @Override
    public String getPassphrase() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean promptPassword(String s) {
        System.out.println(s);
        this.password = s;
        return true;
    }

    @Override
    public boolean promptPassphrase(String s) {
        System.out.println(s);
        return true;
    }

    @Override
    public boolean promptYesNo(String s) {
        System.out.println(s);
        return true;
    }

    @Override
    public void showMessage(String s) {
        System.out.println(s);
    }
}
