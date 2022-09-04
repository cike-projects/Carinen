package io.cike.carinen.handler;

import io.cike.carinen.grpc.InstanceInfo;
import io.cike.carinen.grpc.NamingServerGrpc;
import io.cike.carinen.grpc.ServiceInfo;
import io.cike.carinen.grpc.TODO;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NamingServerHandler extends NamingServerGrpc.NamingServerImplBase {

    private static final Logger logger = LoggerFactory.getLogger(NamingServerHandler.class);

    @Override
    public void heartbeat(InstanceInfo request, StreamObserver<TODO> responseObserver) {
        logger.info("heartbeat: {}", request.getPort());
        responseObserver.onNext(null);
        responseObserver.onCompleted();
    }

    @Override
    public void registerService(ServiceInfo request, StreamObserver<TODO> responseObserver) {
        super.registerService(request, responseObserver);
    }

    @Override
    public void deregisterService(ServiceInfo request, StreamObserver<TODO> responseObserver) {
        super.deregisterService(request, responseObserver);
    }

    @Override
    public void getServiceList(ServiceInfo request, StreamObserver<TODO> responseObserver) {
        super.getServiceList(request, responseObserver);
    }

    @Override
    public void getInstanceList(ServiceInfo request, StreamObserver<TODO> responseObserver) {
        super.getInstanceList(request, responseObserver);
    }

    @Override
    public void watchService(ServiceInfo request, StreamObserver<TODO> responseObserver) {
        super.watchService(request, responseObserver);
    }
}
