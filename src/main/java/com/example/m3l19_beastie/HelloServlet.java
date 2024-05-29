package com.example.m3l19_beastie;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.SingleThreadModel;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    AtomicInteger i = new AtomicInteger(0);

//    int i = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        System.out.println(Thread.currentThread().getName());

        synchronized (this) {
            for (int j = 0; j < 1_000_000; j++) {
                i.getAndIncrement();
            }
        }
        System.out.println(i);

    }

}