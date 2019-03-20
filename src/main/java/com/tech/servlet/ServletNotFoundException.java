package com.tech.servlet;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-19 23:32
 **/
public class ServletNotFoundException extends Exception {

    public ServletNotFoundException() {
        super();
    }

    public ServletNotFoundException(String message) {
        super(message);
    }

    public ServletNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServletNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ServletNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
