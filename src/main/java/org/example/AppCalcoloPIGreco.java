package org.example;

public class AppCalcoloPIGreco {

    public static void main(String[] args) {

        WorkerThread worker = new WorkerThread(0.000000001);
        worker.start();

        InputHandlerThread inputHandler = new InputHandlerThread(worker);
        inputHandler.start();

        double result = worker.getResult();
        inputHandler.doStop();

        System.out.println(result + " - difference " + (Math.PI - result));
        System.out.println("Math.PI: " + Math.PI);


    }
}
