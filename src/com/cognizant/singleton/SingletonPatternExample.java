package com.cognizant.singleton;

public class SingletonPatternExample {

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Initializing application modules...");
        logger2.log("Database connection established successfully.");

        System.out.println("\n--- Verification ---");
        System.out.println("Logger 1 Hashcode: " + logger1.hashCode());
        System.out.println("Logger 2 Hashcode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both variables point to the exact same Logger instance.");
        } else {
            System.out.println("FAILURE: Different Logger instances exist.");
        }
    }
}