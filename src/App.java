package src;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class App {
    public static void main(String[] args) throws IOException {
        // Start server on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Serve static files (HTML/CSS/JS)
        server.createContext("/", exchange -> {
            String path = exchange.getRequestURI().getPath();
            if (path.equals("/")) path = "/index.html";
            
            try {
                byte[] fileBytes = Files.readAllBytes(Paths.get("src/public" + path));
                exchange.sendResponseHeaders(200, fileBytes.length);
                exchange.getResponseBody().write(fileBytes);
            } catch (Exception e) {
                String notFound = "404 - Not Found";
                exchange.sendResponseHeaders(404, notFound.length());
                exchange.getResponseBody().write(notFound.getBytes());
            }
            exchange.close();
        });

        // Simple API endpoint
        server.createContext("/api/hello", exchange -> {
            String response = "Hello from Java backend!";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });

        server.start();
        System.out.println("Server running on http://localhost:8080");
    }
}