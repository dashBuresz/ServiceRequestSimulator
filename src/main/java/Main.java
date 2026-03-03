

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import utils.*;
import utils.Service.ServiceType;


public class Main {
    public static void main(String[] args) {
        Service intService = new Service(ServiceType.INT_SERVICE);
        Service stringService = new Service(ServiceType.STRING_SERVICE);
        Client client = new Client();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        
        CompletableFuture<Void> intFlow = 
            CompletableFuture.supplyAsync(intService::generateIntOutput, threadPool)
                .thenAccept(client::receiveInt)
                .exceptionally(ex -> {System.out.println("int service failed"); return null;});
        CompletableFuture<Void> stringFlow = 
            CompletableFuture.supplyAsync(stringService::generateStringOutput, threadPool)
                .thenAccept(client::receiveString)
                .exceptionally(ex -> {System.out.println("string service failed"); return null;});
        CompletableFuture.allOf(intFlow, stringFlow).join();
        threadPool.shutdown();
    }
}