package view;

import model.MySession;

import javax.swing.*;
import java.awt.*;

public class Frame implements View {
    private JTextField hostNameText;
    private JTextField userNameText;
    private JTextField passwordText;
    private JTextField portText;
    private JButton connect;
    private String hostName;
    private String userName;
    private String password;
    private int port;

    public void startApplication() {
        SwingUtilities.invokeLater(() -> {
            createFrame();
            initEvents();
        });
    }

    private void initEvents() {
        hostNameText.addActionListener(e -> hostName = hostNameText.getText());

        userNameText.addActionListener(e -> userName = userNameText.getText());

        passwordText.addActionListener(e -> password = passwordText.getText());

        portText.addActionListener(e -> port = portText.getHorizontalAlignment());

        connect.addActionListener(e -> MySession.createSession(hostName, userName, password, port));
    }

    private void createFrame() {
        JFrame frame = new JFrame("Exchange Rates");

        frame.setVisible(true);
        frame.setSize(600, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();
        container.setLayout(new GridBagLayout());

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.fill = GridBagConstraints.HORIZONTAL;
        constraints1.insets = new Insets(5, 5, 5, 5);
        constraints1.gridwidth = 1;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.ipadx = 50;
        JLabel hostName = new JLabel("Host name", JLabel.CENTER);
        container.add(hostName, constraints1);

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.fill = GridBagConstraints.HORIZONTAL;
        constraints2.insets = new Insets(5, 5, 5, 5);
        constraints2.gridwidth = 1;
        constraints2.gridx = 1;
        constraints2.gridy = 0;
        constraints2.ipadx = 50;
        JLabel userName = new JLabel("User name", JLabel.CENTER);
        container.add(userName, constraints2);

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.fill = GridBagConstraints.HORIZONTAL;
        constraints3.insets = new Insets(5, 5, 5, 5);
        constraints3.gridwidth = 1;
        constraints3.gridx = 2;
        constraints3.gridy = 0;
        constraints3.ipadx = 50;
        JLabel password = new JLabel("Password", JLabel.CENTER);
        container.add(password, constraints3);

        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.fill = GridBagConstraints.HORIZONTAL;
        constraints4.insets = new Insets(5, 5, 5, 5);
        constraints4.gridwidth = 1;
        constraints4.gridx = 3;
        constraints4.gridy = 0;
        constraints4.ipadx = 20;
        JLabel port = new JLabel("Port", JLabel.CENTER);
        container.add(port, constraints4);

        GridBagConstraints constraints5 = new GridBagConstraints();
        constraints5.fill = GridBagConstraints.HORIZONTAL;
        constraints5.insets = new Insets(5, 5, 5, 5);
        constraints5.gridwidth = 1;
        constraints5.gridx = 0;
        constraints5.gridy = 1;
        constraints5.ipadx = 100;
        constraints5.ipady = 0;
        hostNameText = new JTextField();
        container.add(hostNameText, constraints5);

        GridBagConstraints constraints6 = new GridBagConstraints();
        constraints6.fill = GridBagConstraints.HORIZONTAL;
        constraints6.insets = new Insets(5, 5, 5, 5);
        constraints6.gridwidth = 1;
        constraints6.gridx = 1;
        constraints6.gridy = 1;
        constraints6.ipadx = 100;
        constraints6.ipady = 0;
        userNameText = new JTextField();
        container.add(userNameText, constraints6);

        GridBagConstraints constraints7 = new GridBagConstraints();
        constraints7.fill = GridBagConstraints.HORIZONTAL;
        constraints7.insets = new Insets(5, 5, 5, 5);
        constraints7.gridwidth = 1;
        constraints7.gridx = 2;
        constraints7.gridy = 1;
        constraints7.ipadx = 100;
        constraints7.ipady = 0;
        passwordText = new JTextField();
        container.add(passwordText, constraints7);

        GridBagConstraints constraints8 = new GridBagConstraints();
        constraints8.fill = GridBagConstraints.HORIZONTAL;
        constraints8.insets = new Insets(5, 5, 5, 5);
        constraints8.gridwidth = 1;
        constraints8.gridx = 3;
        constraints8.gridy = 1;
        constraints8.ipadx = 20;
        constraints8.ipady = 0;
        portText = new JTextField();
        container.add(portText, constraints8);

        GridBagConstraints constraints9 = new GridBagConstraints();
        constraints9.fill = GridBagConstraints.HORIZONTAL;
        constraints9.insets = new Insets(5, 5, 5, 5);
        constraints9.gridwidth = 1;
        constraints9.gridx = 4;
        constraints9.gridy = 1;
        constraints9.ipadx = 20;
        constraints9.ipady = 0;
        connect = new JButton("Connect");
        container.add(connect, constraints9);
    }
}
