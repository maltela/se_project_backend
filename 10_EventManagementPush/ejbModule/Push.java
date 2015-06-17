import org.jboss.aerogear.unifiedpush.DefaultPushSender;
import org.jboss.aerogear.unifiedpush.PushSender;
import org.jboss.aerogear.unifiedpush.message.MessageResponseCallback;
import org.jboss.aerogear.unifiedpush.message.UnifiedMessage;
import org.jboss.logging.Logger;


public class Push {

	private static final Logger logger = Logger.getLogger(Push.class);
	
	public static void send() {
	
	
	PushSender defaultPushSender = DefaultPushSender
			.withRootServerURL("https://seprojektpush-fhmuenster.rhcloud.com/ag-push")
			.pushApplicationId("a5f8dc54-85db-4557-9df7-a0d5fbd1ffa0")
			.masterSecret("79f2c3bf-edf9-43ff-a8d6-453fcc004c31").build();

	logger.info(defaultPushSender.getServerURL());
	
	 UnifiedMessage unifiedMessage = UnifiedMessage.withCriteria()
             .aliases("john", "maria")
             .message()
               .alert("Hello from Java Sender API!")
               .sound("default")
               .badge("1") // iOS specific
               .userData("some_key", "some_value") // optional attributes specific to your app
               .userData("title", "Cool Title") // optional cordova Android specific attribute (default is appName)
             .build();
	 
	logger.info(unifiedMessage.toString());
	
	 MessageResponseCallback callback = new MessageResponseCallback() {

        
		@Override
		public void onComplete() {
			logger.info("Success");
	         	
		}
		
		
     };
     defaultPushSender.send(unifiedMessage, callback);
     
	
	
	}


}