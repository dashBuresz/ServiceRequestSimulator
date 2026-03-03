

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


    }
}