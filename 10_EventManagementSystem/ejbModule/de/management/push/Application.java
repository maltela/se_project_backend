package de.management.push;




import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.management.push.Content;

public class Application 
{
    public static void main( String[] args )
    {
        System.out.println( "Sending POST to GCM" );

        String apiKey = "AIzaSyBVJ-LUoiog0H38Qkgz4TYB77Tk6mluU7c";
        Content content = createContent();

        POST2GCM.post(apiKey, content, "JavaClientNachricht");
    }

    public static Content createContent(){

        Content c = new Content();

        // Geräte-ID´s aus Datenbank abfragen 
        
        c.addRegId("APA91bEAwRO67w6tpoGdKSIzQ3QnELhJIo0y_1SGaI5cl8OMnQ9tpsJbZPA3HOAo_BlxEfSd-Mcu_Io4RKQ-AwtnR-Vy9H5S0uZycL6lojcq4-pr-7xw4P5jr7AWKHhKAAq8UBsL2Jv7F8f1YGszxpzIDIYVdtgm6Q");
        c.createData("Test Title", "Test Message");
        
        return c;
    }
}