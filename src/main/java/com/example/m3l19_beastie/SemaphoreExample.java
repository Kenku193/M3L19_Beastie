package com.example.m3l19_beastie;

import java.util.ArrayList;
import java.util.concurrent.CompletionService;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {


        Semaphore semaphore = new Semaphore(25);
        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() ->
            {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int j = 0; j < 3; j++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            );
            threadArrayList.add(thread);


            }
        for (Thread thread : threadArrayList) {
            thread.start();
        }
    }
}
