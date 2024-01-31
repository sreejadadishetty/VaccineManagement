package com.epam.vaccinemanagementtool.uilayer;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BufferSingleton {

    static BufferedReader br = null;

    private BufferSingleton() {

    }

    public static synchronized BufferedReader getBuffer() {
        if (br == null) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        return br;
    }

}
