package model;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.UserInfo;

public class MySession {
    public static void createSession(String hostName, String userName, String password, int port)  {
        JSch jSch = new JSch();

        try {
            com.jcraft.jsch.Session session = jSch.getSession(userName, hostName, port);

            session.setPassword(password);

            UserInfo userInfo = new MyUserInfo();

            session.setUserInfo(userInfo);

            session.setConfig("StrictHostKeyChecking", "no");

            session.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }


    }
}