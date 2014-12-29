package main;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

public class RmiRegistry {
	public static void main (String[] args) throws Exception{
		System.setSecurityManager(new RMISecurityManager());
		LocateRegistry.createRegistry(1099);
		System.out.println("RMI registry running on port 1099");
		Thread.sleep(Long.MAX_VALUE);
	}
}