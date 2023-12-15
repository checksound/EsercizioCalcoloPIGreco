package org.example;

public class CalcoloPIGreco {

    public static double doCalcoloPIGreco(double accurancy) {

        double result = 0;

        int i = 0;

        while(true) {

            result += 4 * Math.pow(-1, i) / (double) (2 * i + 1);

            i++;

            if(Thread.interrupted())
                return result;

            if(Math.abs(Math.PI - result) <= accurancy)
                return result;
        }
    }

    public static void main(String[] args) {

        double result = CalcoloPIGreco.doCalcoloPIGreco(0.0000001);

        System.out.println(result + " - difference " + (Math.PI - result));
        System.out.println("Math.PI: " + Math.PI);

    }
}