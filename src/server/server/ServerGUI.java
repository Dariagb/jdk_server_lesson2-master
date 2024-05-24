package server.server;

import server.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ServerGUI extends JFrame implements ServerView {
    private ServerController controller;
    private JTextArea log;
    private JButton btnStart, btnStop;
    private boolean work;

    public static final int width = 400;
    public static final int height = 300;
    public static final String logPath = "src/server/log.txt";

    List<ClientGUI> clientGUIList;

    public ServerGUI(ServerController controller) {
        this.controller = controller;
        clientGUIList = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setResizable(false);
        setTitle("Chat Server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (work) {
                    appendLog("Server is already running");
                } else {
                    work = true;
                    appendLog("Server started!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!work) {
                    appendLog("Server is already stopped");
                } else {
                    work = false;
                    while (!clientGUIList.isEmpty()) {
                        controller.disconnectUser(clientGUIList.get(clientGUIList.size() - 1));
                    }
                    appendLog("Server stopped!");
                }
            }
        });


    }

    @Override
    public void appendLog(String text) {
        log.append(text + "\n");
    }

    @Override
    public void displayMessage(String message) {

    }}

