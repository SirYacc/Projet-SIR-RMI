import java.rmi.registry.LocateRegistry;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;

public class RmiRegistry {
	public static void main (String[] args) throws Exception{
		String keyPass = null;
		String trustPass = null;

		if(args.length != 2){
			System.out.println("Usage : java -jar registry.jar keyStorePassword trustStorePassword");
			System.exit(-1);
		}

		keyPass = args[0];
		trustPass = args[1];

		System.setProperty("javax.net.ssl.keyStore", "data/registryKeystore.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", keyPass);

		System.setProperty("javax.net.ssl.trustStore", "data/registryTruststore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", trustPass);
		
		System.setProperty("javax.rmi.ssl.client.enabledProtocols", "TLSv1.2");
		System.setProperty("javax.rmi.ssl.client.enabledCipherSuites", 
				"TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");

		LocateRegistry.createRegistry(1099, new SslRMIClientSocketFactory(),
				new SslRMIServerSocketFactory(
						new String[] {"TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384"},
						new String[] {"TLSv1.2"},true));
		System.out.println("RMI registry running on port 1099");
		Thread.sleep(Long.MAX_VALUE);
	}
}
