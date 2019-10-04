package main.testeeal.ee.src.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestRead {

  private static HttpURLConnection connection;

  public static void main(String[] args)  {
    BufferedReader reader;
    String line;
    StringBuffer responceContent = new StringBuffer();

    //Method 1 java.net.HttpUrlConnection
    try {
      URL  url = new URL("http://jsonplaceholder.typicode.com/albums");

      connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setConnectTimeout(5000);
      connection.setReadTimeout(5000);

      int status = connection.getResponseCode();
      System.out.println(status);
      if(status > 299) {
        reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        while((line = reader.readLine()) != null) {
          responceContent.append(line);
        }
        reader.close();
      } else {
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while((line = reader.readLine()) != null) {
          responceContent.append(line);
        }
        System.out.println(responceContent.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      connection.disconnect();
    }
  }
}
