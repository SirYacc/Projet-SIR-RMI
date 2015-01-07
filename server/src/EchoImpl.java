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
				new SslRMIServerSocketFactory(
						new String[] {"TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384"},
						new String[] {"TLSv1.2"},true));
	}

	public String echo(String str) throws RemoteException {
		String ret;
		System.out.println("Recu: " + str);
		ret = "Echo: " + str;
		System.out.println("Renvoi: " + ret);
		return ret;
	}
	
	public static void main (String args[]) throws Exception {
		String keyPass = null;
		String trustPass = null;

		if(args.length != 2){
			System.out.println("Usage : java -jar server.jar keyStorePassword trustStorePassword");
			System.exit(-1);
		}

		keyPass = args[0];
		trustPass = args[1];

		System.setProperty("javax.net.ssl.keyStore", "data/serverKeystore.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", keyPass);

		System.setProperty("javax.net.ssl.trustStore", "data/serverTruststore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", trustPass);

		System.setProperty("javax.rmi.ssl.client.enabledProtocols", "TLSv1.2");
		System.setProperty("javax.rmi.ssl.client.enabledCipherSuites", 
				"TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");

		Registry registry = LocateRegistry.getRegistry(null, 1099, 
				new SslRMIClientSocketFactory());
		EchoImpl obj = new EchoImpl();
		registry.rebind("rmi://localhost/EchoServer", obj);
		System.out.println("EchoServer bound in registry");
	}
}
