package es.ddtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JavaNetURLRESTFulPOSTClient {
	/**
	 * /customer/_search?q=name:secisland
	 */
	private static final String targetURL = "http://192.168.33.204:9200/customer/_search";

    public static void main(String[] args) {
           try {
                  URL targetUrl = new URL(targetURL);
                  HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
                  httpConnection.setDoOutput(true);
                  httpConnection.setRequestMethod("GET");
                  httpConnection.setRequestProperty("Content-Type", "application/json");

                  String input = "{\"query\":{\"bool\":{\"must\":[{\"match_all\":{}}],\"must_not\":[],\"should\":[]}},\"from\":0,\"size\":10,\"sort\":[],\"aggs\":{}}";
                 
                  OutputStream outputStream = httpConnection.getOutputStream();
                  outputStream.write(input.getBytes());
                  outputStream.flush();

                  if (httpConnection.getResponseCode() != 200) {
                         throw new RuntimeException("Failed : HTTP error code : "
                                + httpConnection.getResponseCode());
                  }

                  BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                                (httpConnection.getInputStream())));

                  String output;
                  System.out.println("Output from Server:\n");
                  while ((output = responseBuffer.readLine()) != null) {
                         System.out.println(output);
                  }

                  httpConnection.disconnect();

             } catch (MalformedURLException e) {

                  e.printStackTrace();

             } catch (IOException e) {

                  e.printStackTrace();

            }

           }     
}
