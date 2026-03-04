import java.io.IOException;
import java.io.OutputStream;

import com.sun.management.VMOption.Origin;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MyHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange he) throws IOException {

        // Handle CORS.
        String origin = he.getRequestHeaders().getFirst("Origin");
        he.getResponseHeaders().add("Access-Control-Allow-Origin", origin);
        he.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        he.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

        // Set response headers.
        Headers headers = he.getResponseHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Connection", "close");

        // Send response body.
        String json = "{\"name\":\"Japan\",\"gold\":27,\"silver\":14,\"bronze\":17,\"emerald\":58}";        
        //String response = "This is the response for server 2";
        System.out.println(json);
        he.sendResponseHeaders(200, json.length());
        OutputStream os = he.getResponseBody();
        os.write(json.getBytes());
        os.close();
    }
}
