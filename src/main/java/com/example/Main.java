package com.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        //Thread example
        long number = 10;
        Thread newThread = new Thread(() -> {
            System.out.println("Factorial of " + number + " is " + factorial(number));
        });
        newThread.start();
        //FutureTask example
        ExecutorService threadPool= Executors.newCachedThreadPool();
        Future<Long> futureTask = threadPool.submit(() -> factorial(number));   //this is how we make our factorial method run parallel 
        while (!futureTask.isDone()) 
        {
            System.out.println("FutureTask is not finished yet...");    //it prints this to the standard output while the task is running paralell to it
        }
        long result = futureTask.get(); //retrieves the result of the async tast running
        System.out.println("Factorial of " + number + " is " + result);
        threadPool.shutdown();
        //CompletableFuture example
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> factorial(number));
        while (!completableFuture.isDone())
        {
            System.out.println("CompletableFuture is not finished yet...");
        }
        long result2 = completableFuture.get();
        System.out.println("Factorial of " + number + " is " + result2);
    }
    private static long factorial(long number){
        long factorial = number;
        for (long i = number-1; i > 0; i--)
        {
            factorial = factorial * i;
        }
        return factorial;
    }
}