package main;

import java.rmi.*;

public interface Echo extends Remote {
	public String echo(String str) throws RemoteException;
}