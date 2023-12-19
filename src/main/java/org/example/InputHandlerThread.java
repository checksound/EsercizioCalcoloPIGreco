package org.example;

import java.io.IOException;
import java.util.Scanner;

public class InputHandlerThread extends Thread {

    private Thread wk;
    private Scanner sc;
    public InputHandlerThread(Thread wk) {
        this.wk = wk;
    }

    public void run() {
        System.out.println("Digita per interrompere il calcolo!!");

        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            System.out.println("DIGITATO");
            wk.interrupt();
        }

    }

    public void doStop() {
      if(sc!= null)
          sc.close();
    }
}
