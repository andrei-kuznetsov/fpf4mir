package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.console;

import java.net.InetSocketAddress;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.environment.Fpf4mirEnv;

public class ConsoleContextListener implements ServletContextListener{
	private static final Logger log = Logger.getLogger(ConsoleContextListener.class);
	
    /**
     * Хранилище сервера Jetty
     */
    private Server server = null;
    
    /**
     * Метод вызывается когда контейнер сервлетов запускается
     * @param event 
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        
        try {
            // Создание сервера Jetty на 8081 порту
        	int port = Fpf4mirEnv.getVariableInt("OPENSHIFT_JBOSSAS_WEBSOCKET_PORT", 8081);
        	String host = Fpf4mirEnv.getVariableString("OPENSHIFT_JBOSSAS_IP", "0.0.0.0");

    		log.info("Starting jetty on " + host + ":" + port);
    		
            this.server = new Server(new InetSocketAddress(host, port));
            
            // Регистрируем EchoSocketHandler в сервере Jetty
            EchoSocketHandler chatWebSocketHandler = new EchoSocketHandler();
            // Это вариант хэндлера для WebSocketHandlerContainer
            chatWebSocketHandler.setHandler(new DefaultHandler());
            
            // Вставляем наш хэндлер слушаться jetty
            server.setHandler(chatWebSocketHandler);
            
            // Запускаем Jetty
            server.start();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

	/**
     * Метод вызывается когда контейнер сервлетов останавливается
     * @param event 
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {

        // Если сервер jetty когда-нибудь запустился
        if (server != null) {
            try {
                // останавливаем Jetty
                server.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
