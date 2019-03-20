package com.tech.servlet;

import com.tech.http.Request;
import com.tech.http.Response;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-19 00:17
 **/
public abstract class AbstractMiniServlet {


    public void service(Request request, Response response) {

        if ("get".equalsIgnoreCase(request.getMethod())) {
            this.doGet(request, response);
        } else {
            this.doPost(request, response);
        }


    }


    public abstract void doGet(Request request, Response response);


    public abstract void doPost(Request request, Response response);


}
