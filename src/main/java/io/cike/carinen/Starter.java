package io.cike.carinen;

import io.cike.carinen.server.NamingServer;

import java.io.IOException;

public class Starter {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            NamingServer server = new NamingServer(10086);
            server.start();
            server.blockUntilShutdown();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}