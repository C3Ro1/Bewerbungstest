package com.example.bewerbungstest.domain.test;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class netTest {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/QueueRequest");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to POST
        connection.setRequestMethod("POST");
        // Set the content type
        connection.setRequestProperty("Content-Type", "application/json");
        // Enable input/output streams
        connection.setDoOutput(true);

        // Write the JSON body to the output stream
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = "{\"Sender\":\"new LoggerService()\"}\n{\"message\":\"new JsonObject(\"\")\"}".getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Get the response code (execute the request)
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Handle the response...
    }


}
