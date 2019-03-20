package com.tech.server;

import com.tech.server.component.ServerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-18 21:06
 **/
public class MiniServer {

    private final static Logger logger = LoggerFactory.getLogger(MiniService.class);
    private MiniService miniService;

    public static void main(String[] arg) throws IOException, SAXException {
        MiniServer miniServer = new MiniServer();

        miniServer.init();
    }

    public MiniService getMiniService() {
        return miniService;
    }

    public synchronized void init() throws IOException, SAXException {

        logger.info("The MiniServer is init");


        this.miniService = new MiniService();

        ServerConnector connector = new ServerConnector();

        connector.init(miniService);

        connector.start();
        logger.info("The MiniServer is started");

    }


}
