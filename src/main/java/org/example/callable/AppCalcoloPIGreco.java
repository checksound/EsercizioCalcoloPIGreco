package org.example.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppCalcoloPIGreco {

    public static void main(String[] args) {

        WorkerCalcolaPiGreco worker = new WorkerCalcolaPiGreco(0.000000001);
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Double> result = service.submit(worker);

        /*
        InputHandlerThread inputHandler = new InputHandlerThread(worker);
        inputHandler.start();

        inputHandler.doStop();
        */

        try {
            System.out.println(result + " - difference " + (Math.PI - result.get().doubleValue()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
        System.out.println("Math.PI: " + Math.PI);


    }
}
