package com.tech.server.component;

import com.tech.utils.XmlReader;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Map;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-19 22:14
 **/
public class DispatchServlet {


    private static volatile DispatchServlet dispatchServlet = null;
    private Map<String, String> servletMappings;

    private DispatchServlet() throws IllegalAccessException, SAXException, IOException {
        String rootPath = this.getClass().getResource("/").getPath();
        String configurationPath = rootPath.concat("web.xml");
        servletMappings = XmlReader.getServletMapping(configurationPath);
    }

    public static DispatchServlet getInstance() throws IllegalAccessException, SAXException, IOException {
        if (dispatchServlet == null) {
            synchronized (DispatchServlet.class) {
                if (dispatchServlet == null) {
                    dispatchServlet = new DispatchServlet();
                }
            }
        }
        return dispatchServlet;

    }


    public String getServlet(String request) {
        return servletMappings.get(request);
    }


}
