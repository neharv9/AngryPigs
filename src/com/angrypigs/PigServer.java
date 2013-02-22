package com.angrypigs;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class PigServer implements PigContact {

	public PigServer(){
		
	}
	
	public String sayHello(){
		return "Hello, piggie!";
	}
	
/*
 * 
 * state variables:
 *  - environment object
 *  - its own x,y coords
 *  - bird's landing coords (needs to be captured by a listener
 *  
 * Methods to implement:
 * 	- listenForLandingCoords() (listener for birdApproaching() from other pigs)
 *  - birdApproaching() (rmi)
 *  - status() (rmi)
 *  - was_hit() (rmi)
 * 	- isThreatened() (internal)
 *  - takeEvasiveAction() (internal)
 *  - takeShelter() (rmi)
 *  - broadcastLocation()
 * 	
 */
	
	public static void main(String args[]){
		try {
			PigServer pig = new PigServer();
			PigContact stub = (PigContact) UnicastRemoteObject.exportObject(pig, 0);
			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Pig", stub);

			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
