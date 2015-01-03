package main;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;

public class EchoImpl extends UnicastRemoteObject implements Echo {
	private static final long serialVersionUID = 1L;

	public EchoImpl() throws RemoteException {
		super(0,new SslRMIClientSocketFactory(),
				new SslRMIServerSocketFactory(null,null,true));
	}

	public String echo(String str) throws RemoteException {
		String ret;
		System.out.println("Recu: " + str);
		ret = "Echo: " + str;
		System.out.println("Renvoi: " + ret);
		return ret;
	}
	
	public static void main (String args[]) throws Exception {
		System.setSecurityManager(new RMISecurityManager());
		Registry registry = LocateRegistry.getRegistry(null, 1099, 
				new SslRMIClientSocketFactory());
		EchoImpl obj = new EchoImpl();
		registry.rebind("rmi://localhost/EchoServer", obj);
		System.out.println("EchoServer bound in registry");
	}
}