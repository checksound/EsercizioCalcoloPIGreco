package org.example;

public class AppCalcoloPIGreco {

    public static void main(String[] args) {

        WorkerThread worker = new WorkerThread(0.0000001);
        worker.start();

        InputHandlerThread inputHandler = new InputHandlerThread(worker);
        inputHandler.start();

        double result = worker.getResult();
        System.out.println("SONO QUI!!!");
        inputHandler.doStop();

        System.out.println(result + " - difference " + (Math.PI - result));
        System.out.println("Math.PI: " + Math.PI);


    }
}
