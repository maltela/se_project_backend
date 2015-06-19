package de.management.push;


import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.jboss.aerogear.unifiedpush.DefaultPushSender;
import org.jboss.aerogear.unifiedpush.PushSender;
import org.jboss.aerogear.unifiedpush.exception.PushSenderHttpException;
import org.jboss.aerogear.unifiedpush.message.MessageResponseCallback;
import org.jboss.aerogear.unifiedpush.message.UnifiedMessage;



public class sendPushMessage {
	
	public static Integer action(String msg)
	{
	

	PushSender defaultPushSender = DefaultPushSender.withRootServerURL("https://seprojektpush-fhmuenster.rhcloud.com/ag-push")
            .pushApplicationId("a5f8dc54-85db-4557-9df7-a0d5fbd1ffa0")
            .masterSecret("79f2c3bf-edf9-43ff-a8d6-453fcc004c31")
            .build();
	
	
	
	 UnifiedMessage message = UnifiedMessage.withCriteria()
             .aliases("john", "maria")
             .message()
               .alert("Hello from Java Sender API!")
               .sound("default")
               .badge("1") // iOS specific
               .userData("some_key", "some_value") // optional attributes specific to your app
               .userData("title", "Cool Title") // optional cordova Android specific attribute (default is appName)
             .build();
	 
	
	 
	 defaultPushSender.send(message);
	
	 return 200;
	
		
		}
     };
	           

