package main;

import java.rmi.registry.*;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class EchoClient {
	public static void main(String args[]) throws Exception {
		
		String keyPass		= null;
		String trustPass	= null;
		String msg			= null;
		
		if(args.length != 3){
			System.out.println("Usage : EchoClient keyStorePassword trustStorePassword Message");
			System.exit(-1);
		}
		
		keyPass = args[0];
		trustPass = args[1];
		
		System.setProperty("javax.net.ssl.keyStore", "../data/clientKeystore.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", keyPass);
		
		System.setProperty("javax.net.ssl.trustStore", "../data/clientTruststore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", trustPass);
		
		System.setProperty("javax.rmi.ssl.client.enabledProtocols", "TLSv1.2");
		System.setProperty("javax.rmi.ssl.client.enabledCipherSuites", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
		
		Registry registry = LocateRegistry.getRegistry(null, 1099, 
				new SslRMIClientSocketFactory());
		String url = "rmi://localhost/EchoServer";
		Echo obj = (Echo)registry.lookup(url);
		
		msg = obj.echo(args[2]);
		System.out.println("Envoi: "+args[2]);
		System.out.println(msg);
	}
}