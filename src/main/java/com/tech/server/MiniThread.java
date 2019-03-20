package com.tech.server;

import com.tech.servlet.ServletNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-18 22:05
 **/
public class MiniThread implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MiniThread.class);

    private Socket socket;

    public MiniThread(Socket socket) {
        this.socket = socket;
    }


    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {

        try {

            InputStream inputStream = socket.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String message = bufferedReader.readLine();

            System.out.println(message);

            String[] requestString = message.split(" ");
            String method = requestString[0];
            String requestParameters = requestString[1];
            String protocolVersion = requestString[2];


            LOGGER.info(method + " " + requestParameters + " " + protocolVersion);

//            String servlet = StringUtils.getUrlPath(requestParameters);
//            String servletName = DispatchServlet.getInstance().getServlet(servlet);
//            Object instance = Class.forName(servletName).newInstance();

            if ("GET".equalsIgnoreCase(method)) {
                //TODO: generate the request and response, then invoke the method to set the response.

                String HTTP_HEAD_STRING = "HTTP/1.1 200 \r\n"
                        + "Content-Type: text/html\r\n"
                        + "\r\n";

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                outputStreamWriter.write(HTTP_HEAD_STRING);

                outputStreamWriter.write("Hello");

                outputStreamWriter.flush();

            } else if ("POST".equalsIgnoreCase(method)) {

            } else {
                throw new ServletNotFoundException("The required servlet is not existing");
            }
        } catch (IOException | ServletNotFoundException e) {
            LOGGER.error("Exception occurs", e.getStackTrace());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                LOGGER.error("Can't close the socket");
            }
        }


    }
}
