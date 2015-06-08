package de.management.push;

public class sendPush {
	
	JavaSender defaultJavaSender = new SenderClient.Builder("https://seprojektpush-fhmuenster.rhcloud.com/ag-push/").build();
	UnifiedMessage unifiedMessage = new UnifiedMessage.Builder()
	        .pushApplicationId("a5f8dc54-85db-4557-9df7-a0d5fbd1ffa0")
	        .masterSecret("79f2c3bf-edf9-43ff-a8d6-453fcc004c31")
	        .alert("Hello from Java Sender API!")
	        .build();
	defaultJavaSender.send(unifiedMessage, new MessageResponseCallback() {

	    @Override
	    public void onComplete(int statusCode) {
	        //do cool stuff
	    }

	    @Override
	    public void onError(Throwable throwable) {
	        //bring out the bad news
	    }
	});
}
