package main;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;

public class RmiRegistry {
	public static void main (String[] args) throws Exception{
		System.setSecurityManager(new RMISecurityManager());
		LocateRegistry.createRegistry(1099, new SslRMIClientSocketFactory(),
				new SslRMIServerSocketFactory(
						new String[] {"TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384"},
						//null,
						new String[] {"TLSv1.2"},true));
		System.out.println("RMI registry running on port 1099");
		Thread.sleep(Long.MAX_VALUE);
	}
}