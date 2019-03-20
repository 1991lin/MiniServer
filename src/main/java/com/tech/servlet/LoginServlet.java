package com.tech.servlet;

import com.tech.http.Request;
import com.tech.http.Response;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-19 00:09
 **/
public class LoginServlet extends AbstractMiniServlet {


    @Override
    public void doGet(Request request, Response response) {
        this.doPost(request, response);
    }

    @Override
    public void doPost(Request request, Response response) {


    }
}
