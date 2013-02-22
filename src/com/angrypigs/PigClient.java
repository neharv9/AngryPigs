package com.angrypigs;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PigClient {

    private PigClient() {}

    public static void main(String[] args) {

        //String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(2001);
            PigContact stub = (PigContact) registry.lookup("Pig");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        
        try {
            Registry registry = LocateRegistry.getRegistry(2001);
            PigContact stub = (PigContact) registry.lookup("Pig2");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}