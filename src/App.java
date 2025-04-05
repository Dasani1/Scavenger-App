package src;

import com.sun.net.httpserver.HttpServer;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class App {
    public static void main(String[] args) throws IOException {
        // Initialize users
        User[] users = {
            new User("Silly Billy", 120),
            new User("John Doe", 300),
            new User("John Pork", 220),
            new User("Travis Scott", 150),
            new User("IShowSpeed", 180)
        };
        insertionSort(users);

        // Create server
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Serve static files
        server.createContext("/", exchange -> {
            String path = exchange.getRequestURI().getPath();
            path = path.equals("/") ? "/index.html" : path;
            
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

        // Leaderboard endpoint (manual JSON)
        server.createContext("/api/leaderboard", exchange -> {
            StringBuilder json = new StringBuilder("[");
            for (int i = 0; i < users.length; i++) {
                json.append(String.format(
                    "{\"username\":\"%s\",\"score\":%d}%s",
                    users[i].getUsername(),
                    users[i].getScore(),
                    (i < users.length - 1) ? "," : ""
                ));
            }
            json.append("]");

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            byte[] response = json.toString().getBytes();
            exchange.sendResponseHeaders(200, response.length);
            exchange.getResponseBody().write(response);
            exchange.close();
        });

        server.start();
        System.out.println("Server running on http://localhost:8080");
    }

    // Insertion sort method (same as before)
    public static void insertionSort(User[] users) {
        for (int i = 1; i < users.length; i++) {
            User key = users[i];
            int j = i - 1;
            while (j >= 0 && users[j].getScore() < key.getScore()) {
                users[j + 1] = users[j];
                j--;
            }
            users[j + 1] = key;
        }
    }
}