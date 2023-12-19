# Esercizio Calcolo PiGreco

https://iisponti.gitbook.io/tecnologie_quinta_2023_24/concorrenza#calcolo-approssimazioni-di-pi-greco

## How to interrupt java.util.Scanner nextLine call

Questo è il thread che nella versione iniziale catturava l'eventuale input dell'utente.
In caso di input dell'utente, veniva inviato il messaggio di `interrupt()` al thread di cui si
vuole terminare l'esecuzione.

```java

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
        System.out.println("DO STOP INPUT");
      if(sc!= null)
          sc.close();
        System.out.println("FINE DO STOP INPUT");
    }
}

```

Dato `sc` oggetto di tipo `Scanner`, `sc.hasNextLine()` se l'utente non digita nulla 
blocca il thread e non è possibile sboccarlo neppure con la `close` su `Scanner`.

https://stackoverflow.com/questions/4983065/how-to-interrupt-java-util-scanner-nextline-call