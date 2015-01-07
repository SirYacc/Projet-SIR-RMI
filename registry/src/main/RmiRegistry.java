package main;

import java.rmi.registry.LocateRegistry;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;

public class RmiRegistry {
	public static void main (String[] args) throws Exception{
		
		System.setProperty("javax.net.ssl.keyStore", "../data/registryKeystore.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "ilfaitbeau");
		
		System.setProperty("javax.net.ssl.trustStore", "../data/registryTruststore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "cocolasticot");
		
		System.setProperty("javax.rmi.ssl.client.enabledProtocols", "TLSv1.2");
		System.setProperty("javax.rmi.ssl.client.enabledCipherSuites", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
		
		LocateRegistry.createRegistry(1099, new SslRMIClientSocketFactory(),
				new SslRMIServerSocketFactory(
						new String[] {"TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384"},
						//null,
						new String[] {"TLSv1.2"},true));
		System.out.println("RMI registry running on port 1099");
		Thread.sleep(Long.MAX_VALUE);
	}
}