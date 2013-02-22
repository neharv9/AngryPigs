package com.angrypigs;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class PigServer2 implements PigContact {

	public PigServer2(){
		
	}
	
	public String sayHello(){
		return "Hello, piggie!2";
	}
	
	public static void main(String args[]){
		try {
			PigServer2 pig = new PigServer2();
			PigContact stub = (PigContact) UnicastRemoteObject.exportObject(pig, 0);
			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry(2001);
			registry.bind("Pig2", stub);

			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}