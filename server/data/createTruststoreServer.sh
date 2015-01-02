#! /bin/bash

keytool -import -file ../../client/data/clientCertificate.crt \
-alias client -keystore serverTruststore.jks;
keytool -import -file ../../registry/data/registry.crt -alias registry \
-keystore serverTruststore.jks;


