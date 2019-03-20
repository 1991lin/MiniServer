package com.tech.utils;

import com.tech.pojo.Servlet;
import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-19 08:16
 **/
public class XmlReader {


    /**
     * get the servlets configurations
     *
     * @param propertyFilePath
     * @return
     * @throws IOException
     * @throws SAXException
     */
    public static Servlet getConfiguredServlets(String propertyFilePath) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("Servlet", Servlet.class);
        digester.addSetProperties("Servlets/Servlet");
        digester.addBeanPropertySetter("Servlet/url", "url");
        digester.addBeanPropertySetter("Servlet/servletClass", "servletClass");
        Object obj = digester.parse(new File(propertyFilePath));
        if (obj instanceof Servlet) {
            return (Servlet) obj;
        } else {
            return null;
        }

    }


    public static Map<String, String> getServletMapping(String propertyFilePath) throws IOException, SAXException, IllegalAccessException {
        Servlet servlet = getConfiguredServlets(propertyFilePath);

        Map<String, String> servletConfig = new HashMap<>();
        Field[] fields = Servlet.class.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            servletConfig.put(field.getName(), field.get(servlet).toString());
        }

        return servletConfig;
    }


    public static void main(String[] arg) throws IOException, SAXException {
        Servlet servlets = XmlReader.getConfiguredServlets("/Users/eric/IdeaProjects/MiniServer/src/main/resources/web.xml");
        System.out.println(servlets.toString());

    }


}
