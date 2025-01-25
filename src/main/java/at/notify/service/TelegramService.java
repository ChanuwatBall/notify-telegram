package at.notify.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import org.apache.http.protocol.HttpService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TelegramService {
  

    @Value("${telegram.bot.token}")
    private String botToken;

    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot";
 

    public void sendMessage(String chatId, String message) {
        // String url = TELEGRAM_API_URL + botToken + "/sendMessage";

        // RestTemplate restTemplate = new RestTemplate();

        // String payload = String.format("{\"chat_id\": \""+chatId+"\", \"text\": \" "+message+"\"}" );

        // restTemplate.postForObject(url, payload, String.class);
        // HttpService service = new HttpService();
        // String response = service.sendHttpsRequest("https://example.com/api", "{\"key\":\"value\"}");
        // System.out.println(response);

        HttpClient client = HttpClient.newHttpClient();

        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.telegram.org/bot"+botToken+"/sendMessage"))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        
    }
}
