package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandlerThread extends Thread {

    private Thread wk;
    private volatile boolean attivo;

    private BufferedReader br;
    public InputHandlerThread(Thread wk) {
        this.wk = wk;
    }

    public void run() {
        attivo = true;
        System.out.println("Digita per interrompere il calcolo!!");

        br = new BufferedReader(new InputStreamReader(System.in));

            try {
                // wait until we have data to complete a readLine()
                while (!br.ready() && attivo ) {
                    Thread.sleep(10);
                }

                if(!attivo) {
                    br.close();
                    return;
                }


                String input = br.readLine();
                System.out.println("DIGITATO");
                wk.interrupt();
                br.close();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }

    public void doStop() {
      attivo = false;
    }
}
