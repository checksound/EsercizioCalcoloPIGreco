package org.example.bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalcoloPIGrecoBigDecimal {
    public static BigDecimal doCalcoloPIGreco(double accuracy) {

        BigDecimal result = new BigDecimal(0);

        int i = 0;

        BigDecimal accuracyBd = new BigDecimal(Double.toString(accuracy));
        //BigDecimal accuracyBd = new BigDecimal(accuracy);
        // System.out.println(accuracyBd);
        int precision = accuracyBd.precision();
        int scale = accuracyBd.scale();
        /*
        System.out.println("PRECISION: " + precision +
                " SCALE: " + scale);
        */
        BigDecimal piGrecoBd = new BigDecimal(Double.toString(Math.PI));

        /*
        System.out.println("PRECISION: " + piGrecoBd.precision() +
                " SCALE: " + piGrecoBd.scale());
        */
        // Set precision to 5
        MathContext mc
                = new MathContext(scale);

        BigDecimal numerator = new BigDecimal(1);

        while(true) {
            BigDecimal denominator = new BigDecimal(2 * i + 1);
            BigDecimal addPart = numerator.divide(denominator, mc).multiply(new BigDecimal(4));
            // System.out.println("prima result: " + result);

            if(Math.pow(-1, i) >=0)
                result = result.add(addPart);
            else
                result = result.subtract(addPart);

            // System.out.println("addPart: " + addPart + ", result: " + result);
            i++;

            if(Thread.interrupted())
                return result;


            BigDecimal difference = result.subtract(piGrecoBd);

            if(difference.abs().compareTo(accuracyBd) <= 0) {
                return result;
            }
        }

    }

    public static void main(String[] args) {

        // double accuracy = 0.000000001;
        double accuracy = 0.000000001;
        double start = System.currentTimeMillis();
        BigDecimal result = CalcoloPIGrecoBigDecimal.doCalcoloPIGreco(accuracy);
        System.out.println("Tempo di calcolo: " + (System.currentTimeMillis() - start));

        System.out.println(result + " - difference " + (result.subtract(new BigDecimal(Math.PI))));
        System.out.println("Math.PI: " + Math.PI);

    }
}