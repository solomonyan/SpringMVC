package com.springapp.mvc;

/**
 * Created by solomonyan on 15/6/14.
 */
public class TestDrive {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
            //on classpath
        } catch (ClassNotFoundException e) {
            // not on classpath
        }
    }
}
