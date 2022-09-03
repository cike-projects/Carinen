package io.cike.carinen.handler;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NamingServerHandlerTest {

    NamingServerHandlerClient client;
    ManagedChannel channel;

    @BeforeAll
    public void beforeAll() {
        String target = "localhost:10086";

        channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();

        client = new NamingServerHandlerClient(channel);
    }

    @AfterAll
    public void afterAll() {
        channel.shutdownNow();
    }

    @Test
    void heartbeat() {
        client.heartbeat(12345);
    }
}