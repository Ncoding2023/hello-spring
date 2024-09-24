package hello.hello_spring.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
/*

유저용
        live_30607ce3142602547a16c2dc58b1ce3bcf93846242eaf42156348eb619ec875aa3c7fee3c5ebf25367a9d6d298758251
개발용
        test_04bb9f226459f9f45680adc3c5d463aab490e8d54da4b045726d2708a3f7954eefe8d04e6d233bd35cf2fabdeb93fb0d
*/

public class  ApiExample {
    public static void main(String[] args) {
        try {
            
            
            String API_KEY = "test_04bb9f226459f9f45680adc3c5d463aab490e8d54da4b045726d2708a3f7954eefe8d04e6d233bd35cf2fabdeb93fb0d";
            String API_KEY_USER = "live_30607ce3142602547a16c2dc58b1ce3bcf93846242eaf42156348eb619ec875aa3c7fee3c5ebf25367a9d6d298758251";
            String cname = "처어어";
            String characterName = URLEncoder.encode(cname, StandardCharsets.UTF_8);

//            String urlString = "https://open.api.nexon.com/heroes/v1/id?character_name=" + characterName;
            String urlString = "https://open.api.nexon.com/maplestory/v1/id?character_name=" + characterName;
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-nxopen-api-key", API_KEY);

            int responseCode = connection.getResponseCode();

            BufferedReader in;
            if(responseCode == 200) {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
