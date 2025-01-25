package at.notify.service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.stereotype.Service;
 

@Service
public class HttpService {

      public String sendHttpsRequest(String url, String requestBody) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String sendGetRequest(String baseUrl, Map<String, String> params) throws Exception {
        StringBuilder url = new StringBuilder(baseUrl);

        if (params != null && !params.isEmpty()) {
            url.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                url.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8))
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                        .append("&");
            }
            // Remove the trailing "&"
            url.deleteCharAt(url.length() - 1);
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(url.toString()))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String sendPostRequest(String baseUrl, String requestBody, Map<String, String> params) throws Exception {
        StringBuilder url = new StringBuilder(baseUrl);

        if (params != null && !params.isEmpty()) {
            url.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                url.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8))
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                        .append("&");
            }
            // Remove the trailing "&"
            url.deleteCharAt(url.length() - 1);
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder() 
                .uri(URI.create(url.toString()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
