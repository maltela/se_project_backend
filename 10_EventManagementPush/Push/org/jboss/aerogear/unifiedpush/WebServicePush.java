package org.jboss.aerogear.unifiedpush;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.jboss.aerogear.unifiedpush.message.UnifiedMessage;
import org.jboss.logging.Logger;

import org.jboss.aerogear.unifiedpush.DefaultPushSender;
import org.jboss.aerogear.unifiedpush.PushSender;


@WebService(serviceName = "EventManagementPush")
@Stateless
public class WebServicePush {

	private static final Logger logger = Logger.getLogger(WebServicePush.class);

	/**
	 * 5. Schnittstelle - Push Nachrichten versenden
	 * 
	 * @author Malte Lange
	 * @param msg
	 * @return
	 */
	@WebMethod(operationName = "sendPush")
	public Integer sendPush(@WebParam(name = "msg") String msg) {

		logger.debug("Push Aufruf");
		PushSender defaultPushSender = DefaultPushSender
				.withRootServerURL(
						"https://seprojektpush-fhmuenster.rhcloud.com/ag-push")
				.pushApplicationId("a5f8dc54-85db-4557-9df7-a0d5fbd1ffa0")
				.masterSecret("79f2c3bf-edf9-43ff-a8d6-453fcc004c31").build();

		logger.debug("Push Sender erstellt");
		//defaultPushSender.send();
		UnifiedMessage unifiedMessage = UnifiedMessage.withCriteria()
                .aliases("john", "maria")
                .message()
                  .alert("Hello from Java Sender API!")
                  .sound("default")
                  .badge("1") // iOS specific
                  .userData("some_key", "some_value") // optional attributes specific to your app
                  .userData("title", "Cool Title") // optional cordova Android specific attribute (default is appName)
                .build();

		defaultPushSender.send(unifiedMessage);

		logger.debug("Push Message erstellt");

		// defaultPushSender.send(message);

		return 200;
	}

}
