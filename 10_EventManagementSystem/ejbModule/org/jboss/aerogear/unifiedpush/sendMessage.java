package org.jboss.aerogear.unifiedpush;

import java.io.Serializable;
import java.util.Arrays;

import org.jboss.aerogear.unifiedpush.message.UnifiedMessage;
import org.jboss.aerogear.unifiedpush.message.UnifiedMessage.MessageBuilder;
import org.jboss.logging.Logger;

import de.management.dao.EventManagementDAO;

public class sendMessage implements Serializable {
	private static final Logger logger = Logger.getLogger(sendMessage.class);
	//@Inject
	//private static PushSender defaultPushSender;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void action(String msg,Integer eventID) 
	{

		 PushSender defaultPushSender = DefaultPushSender.withRootServerURL("https://seprojektpush-fhmuenster.rhcloud.com/ag-push/")
				    .pushApplicationId("a5f8dc54-85db-4557-9df7-a0d5fbd1ffa0")
				    .masterSecret("79f2c3bf-edf9-43ff-a8d6-453fcc004c31")
				    .build();

		 UnifiedMessage unifiedMessage = UnifiedMessage.withMessage()
				              .alert("Message: "+msg)
				              .sound("default")
				              .criteria()
				                   .variants("c3f0a94f-48de-4b77-a08e-68114460857e") // e.g. HR_Premium
				                   .aliases("mike", "john")
				                   .categories("sport", "world cup")
				                   .deviceType("iPad", "AndroidTablet")
				              .build();
	        
		 
		 
		      
		 	defaultPushSender.send(unifiedMessage);	

		 	
		 	
		
	 	
   
	}

}
