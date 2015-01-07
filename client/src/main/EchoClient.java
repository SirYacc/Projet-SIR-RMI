package main;

import java.rmi.RMISecurityManager;
import java.rmi.registry.*;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class EchoClient {
	public static void main(String args[]) throws Exception {
		
		System.setProperty("javax.net.ssl.keyStore", "../data/clientKeystore.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "ilfaitbeau");
		
		System.setProperty("javax.net.ssl.trustStore", "../data/clientTruststore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "cocolasticot");
		
		System.setProperty("javax.rmi.ssl.client.enabledProtocols", "TLSv1.2");
		System.setProperty("javax.rmi.ssl.client.enabledCipherSuites", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
		
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