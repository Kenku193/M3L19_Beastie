package com.example.m3l19_beastie;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Solution {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() ->
            {
                try {
                    URLConnection urlConnection = new URL("http://localhost:8080/M3L19_Beastie_war_exploded/hello-servlet")
                            .openConnection();
                    urlConnection.getInputStream();

                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            ).start();
        }
    }
}
