package org.example;

public class WorkerThread extends Thread {

    private double accurancy;

    private double result;

    public WorkerThread(double accurancy) {
        this.accurancy = accurancy;
    }

    public void run() {
        System.out.println("PARTENZA Calcolo Pigreco");
        result = CalcoloPIGreco.doCalcoloPIGreco(accurancy);
    }

    public double getResult() {
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}
