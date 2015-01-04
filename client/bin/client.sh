#! /bin/bash

java -Djava.security.policy=../my.policy \
-Djavax.net.ssl.keyStore=../data/clientKeystore.jks \
-Djavax.net.ssl.keyStorePassword=ilfaitbeau \
-Djavax.net.ssl.trustStore=../data/clientTruststore.jks \
-Djavax.net.ssl.trustStorePassword=cocolasticot \
-Djavax.rmi.ssl.client.enabledProtocols=TLSv1.2 \
-Djavax.rmi.ssl.client.\
enabledCipherSuites=TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 \
main.EchoClient hello
