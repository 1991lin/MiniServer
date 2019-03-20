package com.tech.server.component;

import com.tech.constant.ServerConstants;
import com.tech.server.MiniService;
import com.tech.server.MiniThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-19 21:22
 **/
public class ServerConnector {


    private MiniService miniService;

    public void init(MiniService miniService) {

        this.miniService = miniService;

    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(ServerConstants.PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            miniService.submitJob(new MiniThread(socket));
        }
    }

}
