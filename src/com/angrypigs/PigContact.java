package com.angrypigs;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PigContact extends Remote {
	String sayHello() throws RemoteException;
	//String sayHello2() throws RemoteException;
}
