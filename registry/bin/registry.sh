#! /bin/bash

java -Djava.rmi.server.codebase=file:///home/user0/Documents/git/\
Projet-SIR-RMI/server/bin/ \
-Djava.security.policy=../my.policy \
-Djavax.net.ssl.keyStore=../data/registryKeystore.jks \
-Djavax.net.ssl.keyStorePassword=ilfaitbeau \
-Djavax.net.ssl.trustStore=../data/registryTruststore.jks \
-Djavax.net.ssl.trustStorePassword=cocolasticot \
-Djavax.rmi.ssl.client.enabledProtocols=TLSv1.2 \
-Djavax.rmi.ssl.client.\
enabledCipherSuites=TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 \
-Djavax.net.debug=ssl \
main.RmiRegistry

#-Djavax.rmi.ssl.client.enabledCipherSuites=TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 \
