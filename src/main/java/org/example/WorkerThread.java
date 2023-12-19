package org.example;

public class WorkerThread extends Thread {

    private double accuracy;

    private double result;

    public WorkerThread(double accuracy) {
        this.accuracy = accuracy;
    }

    public void run() {
        System.out.println("PARTENZA Calcolo Pigreco");
        result = CalcoloPIGreco.doCalcoloPIGreco(accuracy);
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
