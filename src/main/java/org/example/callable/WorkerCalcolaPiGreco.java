package org.example.callable;

import java.util.concurrent.Callable;

public class WorkerCalcolaPiGreco implements Callable<Double> {

    private double accuracy;

    private double result;

    public WorkerCalcolaPiGreco(double accuracy) {
        this.accuracy = accuracy;
    }

    public Double call() {
        System.out.println("PARTENZA Calcolo Pigreco");
        return result = CalcoloPIGreco.doCalcoloPIGreco(accuracy);
    }

}
