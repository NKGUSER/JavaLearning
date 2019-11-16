package com.test;

import java.util.Queue;


// if we don't call wait() or notify() method from synchronized context 
// we will receive IllegalMonitorStateException in Java.

// race condition between wait() and notify() in Java which could exist 
// if we don't call them inside synchronized method or block. 


// Blocking Queue should be implemented to block the access to put an element if Queue is Full
// or poll/take and element if Queue is empty.

public class Producer extends Thread {
    private final Queue sharedQ;

    public Producer(Queue sharedQ) {
        super("Producer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {

        for (int i = 0; i < 4; i++) {

            synchronized (sharedQ) {
                //waiting condition - wait until Queue is not empty
                while (sharedQ.size() >= 1) {
                    try {
                        System.out.println(" Queue is full, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("producing : " + i);
                sharedQ.add(i);
                sharedQ.notify();
            }
        }
    }
}