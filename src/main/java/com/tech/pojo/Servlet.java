package com.tech.pojo;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-19 08:14
 **/
public class Servlet {

    private String url;
    private String servletClass;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServletClass() {
        return servletClass;
    }

    public void setServletClass(String servletClass) {
        this.servletClass = servletClass;
    }

    @Override
    public String toString() {
        return "Servlet{" +
                "url='" + url + '\'' +
                ", servletClass='" + servletClass + '\'' +
                '}';
    }
}
