package model;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.UserInfo;

public class MySession {
    private com.jcraft.jsch.Session createSession(String hostName, String userName, String password, int port) throws JSchException {
        JSch jSch = new JSch();

        com.jcraft.jsch.Session session = jSch.getSession(hostName, userName, port);

        session.setPassword(password);

        UserInfo userInfo = new MyUserInfo();

        session.setUserInfo(userInfo);

        session.setConfig("StrictHostKeyChecking", "no");

        session.connect(10000);

        return session;
    }
}