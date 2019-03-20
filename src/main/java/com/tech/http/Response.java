package com.tech.http;

import java.io.OutputStream;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-19 00:07
 **/
public class Response {

    private static final String HTTP_HEAD_STRING = "HTTP/1.1 200 \r\n"
            + "Content-Type: text/html\r\n"
            + "\r\n";
    private OutputStream outputStream;


    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }


}
