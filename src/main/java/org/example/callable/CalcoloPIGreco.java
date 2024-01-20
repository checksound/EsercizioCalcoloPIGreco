package org.example.callable;

public class CalcoloPIGreco {

    public static double doCalcoloPIGreco(double accuracy) {

        double result = 0;

        int i = 0;

        while(true) {

            result += 4 * Math.pow(-1, i) / (double) (2 * i + 1);

            i++;

            if(Thread.interrupted())
                return result;

            if(Math.abs(Math.PI - result) <= accuracy)
                return result;
        }
    }

    public static void main(String[] args) {

        double accuracy = 0.000000001;
        double start = System.currentTimeMillis();
        double result = CalcoloPIGreco.doCalcoloPIGreco(accuracy);
        System.out.println("Tempo di calcolo: " + (System.currentTimeMillis() - start));

        System.out.println(result + " - difference " + (Math.PI - result));
        System.out.println("Math.PI: " + Math.PI);

    }
}