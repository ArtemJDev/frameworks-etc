package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

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
//        System.out.println(responceContent.toString());

        parse(responceContent.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      connection.disconnect();
    }



  }
//add json lib
  public static String parse(String responseBody) {
    JSONArray  albums = new JSONArray(responseBody);
    for (int i = 0; i < albums.length(); i++) {
      JSONObject album = albums.getJSONObject(i);
      int id = album.getInt("id");
      int userId = album.getInt("userId");
      String title = album.getString("title");
      System.out.println( id + " " + userId + " " + title);
    }
    return null;
  }
}
