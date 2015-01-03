package main;

import java.rmi.RMISecurityManager;
import java.rmi.registry.*;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class EchoClient {
	public static void main(String args[]) throws Exception {
		System.setSecurityManager(new RMISecurityManager());
		Registry registry = LocateRegistry.getRegistry(null, 1099, 
				new SslRMIClientSocketFactory());
		String url = "rmi://localhost/EchoServer";
		Echo obj = (Echo)registry.lookup(url);
		String msg = obj.echo(args[0]);
		System.out.println("Envoi: "+args[0]);
		System.out.println(msg);
	}
}