package com.example.java.thread;

public class ThreadSyncExample {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {
            Integer i = 0;
            while (!stopRequested) {
                synchronized (i) {
                    i++;
                }
            }
            System.out.println("i : " + i);
        });

        backgroundThread.start();
//        Thread.sleep(1000);
        System.out.println("stopRequested : " + stopRequested);
        stopRequested = true;
    }

}
