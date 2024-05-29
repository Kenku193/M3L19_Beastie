package com.example.m3l19_beastie;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    private static final AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() ->
            {
                for (int j = 0; j < 100; j++) {
                    count.getAndIncrement();
                }
            }
                    );
            thread.start();
            threadArrayList.add(thread);
        }

//        for (Thread thread : threadArrayList) {
//            thread.join();
//        }

        System.out.println(count);

        //....

    }

}
