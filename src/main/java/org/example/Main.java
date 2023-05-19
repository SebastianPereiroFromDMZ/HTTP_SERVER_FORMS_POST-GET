package org.example;

import java.io.IOException;

public class Main {



    public static void main(String[] args) {

        Server server = new Server();
        server.start();

        server.addHandler("GET", "/message", ((request, responseStream) -> {
            try {
                server.responseWithoutContent(responseStream, "404", "Not found");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));

        server.addHandler("POST", "/message", (request, responseStream) ->
                server.responseWithoutContent(responseStream, "404", "Not found"));
        server.addHandler("GET", "/", ((request, responseStream) -> server.defaultHandler(responseStream, "spring.png")));
        server.listenToServer();
    }
}