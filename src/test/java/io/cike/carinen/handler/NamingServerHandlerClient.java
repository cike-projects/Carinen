package io.cike.carinen.handler;

import io.cike.carinen.grpc.InstanceInfo;
import io.cike.carinen.grpc.NamingServerGrpc;
import io.grpc.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NamingServerHandlerClient {
  private static final Logger logger = LoggerFactory.getLogger(NamingServerHandlerClient.class);

  private final NamingServerGrpc.NamingServerBlockingStub blockingStub;

  public NamingServerHandlerClient(Channel channel) {
    blockingStub = NamingServerGrpc.newBlockingStub(channel);
  }

  public void heartbeat(int port) {
    InstanceInfo instanceInfo = InstanceInfo.newBuilder().setPort(port).build();
    blockingStub.heartbeat(instanceInfo);
  }

}
