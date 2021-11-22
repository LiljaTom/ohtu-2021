package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        Arrays.sort(players, (p1, p2) -> p2.getPoints() - p1.getPoints());

        for (Player player : players) {
            if(player.getNationality().equals("FIN")) {
                System.out.println(player);
            }
        }   
    }
  
}