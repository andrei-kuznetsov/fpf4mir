package ru.spbstu.icc.kspt.kuznetsov.fpf4mir;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.codestore.LastLogMessage;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.codestore.TextLogMessage;

public class JmsLogProducer {
	   private static final Logger log = Logger.getLogger(JmsLogProducer.class.getName());

	    // Set up all the default values
	    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	    private static final String DEFAULT_DESTINATION = "jms/queue/test";
	    private static final String DEFAULT_USERNAME = "quickstartUser";
	    private static final String DEFAULT_PASSWORD = "quickstartPwd1!";
	    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	    private static final String PROVIDER_URL = "remote://localhost:4447";

	    public static void main(String[] args) throws Exception {

	        ConnectionFactory connectionFactory = null;
	        Connection connection = null;
	        Session session = null;
	        MessageProducer producer = null;
	        Destination destination = null;
	        ObjectMessage message = null;
	        Context context = null;

	        try {
	            // Set up the context for the JNDI lookup
	            final Properties env = new Properties();
	            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
	            env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
	            env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", DEFAULT_USERNAME));
	            env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", DEFAULT_PASSWORD));
	            context = new InitialContext(env);

	            // Perform the JNDI lookups
	            String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
	            log.info("Attempting to acquire connection factory \"" + connectionFactoryString + "\"");
	            connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
	            log.info("Found connection factory \"" + connectionFactoryString + "\" in JNDI");

	            String destinationString = System.getProperty("destination", DEFAULT_DESTINATION);
	            log.info("Attempting to acquire destination \"" + destinationString + "\"");
	            destination = (Destination) context.lookup(destinationString);
	            log.info("Found destination \"" + destinationString + "\" in JNDI");

	            // Create the JMS connection, session, producer, and consumer
	            connection = connectionFactory.createConnection(System.getProperty("username", DEFAULT_USERNAME), System.getProperty("password", DEFAULT_PASSWORD));
	            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	            producer = session.createProducer(destination);
	            connection.start();

	            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	            String line = null;

	            while((line = in.readLine()) != null) {
	                message = session.createObjectMessage(new TextLogMessage("test", 0, line));
	                producer.send(message);
	            }
	            
	            message = session.createObjectMessage(new LastLogMessage("test", 0));
                producer.send(message);
	        } catch (Exception e) {
	            log.severe(e.getMessage());
	            throw e;
	        } finally {
	            if (context != null) {
	                context.close();
	            }

	            // closing the connection takes care of the session, producer, and consumer
	            if (connection != null) {
	                connection.close();
	            }
	        }
	    }
}
