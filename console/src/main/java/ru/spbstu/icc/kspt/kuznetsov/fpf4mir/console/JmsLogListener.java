package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.console;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.codestore.LastLogMessage;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.codestore.LogMessageBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.codestore.TextLogMessage;


@MessageDriven(name = "LogMessageListener", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test"),
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class JmsLogListener implements MessageListener {
	private static final Logger log = Logger.getLogger(JmsLogListener.class);
	
	@Override
	public void onMessage(Message inMessage) {
		if (inMessage instanceof ObjectMessage){
			log.info("Object message");
			ObjectMessage msg = (ObjectMessage)inMessage;
			try {
				LogMessageBase lm = (LogMessageBase) msg.getObject();
				log.info(lm);
				if (lm instanceof TextLogMessage){
					EchoSocketHandler.processMessage((TextLogMessage) lm);
				} else if (lm instanceof LastLogMessage){
					EchoSocketHandler.disconnectClients((LastLogMessage) lm);
				} 
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else if (inMessage instanceof TextMessage){
			log.info("Text message");
			TextMessage msg = (TextMessage)inMessage;
			try {
				EchoSocketHandler.processMessage(new TextLogMessage(null, 0, msg.getText()));
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			log.warn("Unexpected message: " + inMessage);
		}
	}
}
