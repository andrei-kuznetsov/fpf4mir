package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.console;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketHandler;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.codestore.LastLogMessage;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.codestore.TextLogMessage;

public class EchoSocketHandler extends WebSocketHandler
{
	private static final Logger log = Logger.getLogger(EchoSocketHandler.class);

    /**
     * Набор открытых сокетов
     */
    private final static Map<String, Set<EchoWebSocket>> webSockets = new ConcurrentHashMap<String, Set<EchoWebSocket>>();

    /**
     * Выполняется когда пытается открыться новое соединение
     * @param request
     * @param protocol протокол (бывает двух видов ws и wss)
     * @return 
     */
    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest request,
            String protocol) {
    	log.trace("doWebSocketConnect");
    	log.info(request.getPathInfo());
 ///http://docs.oracle.com/javaee/6/tutorial/doc/gjiie.html

        return new EchoWebSocket(request.getPathInfo());
    }

    public static void processMessage(TextLogMessage msg){
    	final String submissionId = msg.getSubmissionId();
    	
    	if (submissionId != null){
	    	final int runId = msg.getRunId();
			final String submissionPath = String.format("/%s/%d", submissionId, runId);
	    	processMessage(submissionPath, msg.getMessage());
    	} else {
    		log.warn("Submission ID is required but hasn't been provided. Logging to console with severe 'DEBUG' instead");
    		log.debug(msg.getMessage());
    	}
    }

	private static void processMessage(final String submissionPath, String msg) {
		
		Set<EchoWebSocket> clients = webSockets.get(submissionPath);
		
		if (clients != null){
		    for (EchoWebSocket webSocket : clients) {
		        try {
					webSocket.connection.sendMessage(msg);
				} catch (IOException e) {
					log.error("Can't send message", e);
					webSocket.connection.disconnect();
				}
		    }
		}
	}
    
    public static void disconnectClients(LastLogMessage msg){
    	final String submissionId = msg.getSubmissionId();
    	
    	if (submissionId != null){
	    	final int runId = msg.getRunId();
	    	final String path = String.format("/%s/%d", submissionId, runId);
	    	
	    	Set<EchoWebSocket> clients = webSockets.get(path);
	    	
	    	if (clients != null){
		        for (EchoWebSocket webSocket : clients) {
					webSocket.connection.disconnect();
		        }
		        
		        clients.clear();
	    	}
    	}
    }
    
    private class EchoWebSocket implements WebSocket.OnTextMessage {
    	final private String submissionPath;
    	
    	
        public EchoWebSocket(String submissionPath) {
			super();
			this.submissionPath = submissionPath;
		}

		/**
         * Хранилище соединения
         */
        private Connection connection;
        
        /**
         * Выполняется когда открыто новое соединение
         * @param connection 
         */
        @Override
        public void onOpen(Connection connection) {
        	log.trace("onOpen");
        	
        	// Сохраняем соединение в свойство ChatWebSocket::connection
            this.connection = connection;
            
        	Set<EchoWebSocket> clients = webSockets.get(submissionPath);
        	
        	if (clients == null){
	        	synchronized (webSockets) {
	        		clients = webSockets.get(submissionPath);
	            	if (clients == null){
	            		clients = new ConcurrentHashSet<EchoWebSocket>();
	            		webSockets.put(submissionPath, clients);
	            	}
				}
        	}
        	
        	clients.add(this);
        }

        /**
         * Выполняется когда пришло новое сообщение
         * @param data 
         */
        @Override
        public void onMessage(String data) {
        	log.trace("onMessage");
        	EchoSocketHandler.processMessage(submissionPath, data);
        }

        /**
         * Выполняется когда клиент разъединяется от сервера
         * @param closeCode
         * @param message 
         */
        @Override
        public void onClose(int closeCode, String message) {
        	log.trace("onClose");
        	Set<EchoWebSocket> clients = webSockets.get(submissionPath);
        	clients.remove(this);
        }
    }
}
