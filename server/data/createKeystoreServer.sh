#! /bin/bash

cat privkey.pem godard-tp.pem g1010419.tp.pem > mykeycertificate.pem;
openssl pkcs12 -export -in mykeycertificate.pem -out serverKeystore.pkcs12 -name serverkey -noiter -nomaciter;
keytool -importkeystore -srckeystore serverKeystore.pkcs12 -srcstoretype PKCS12 -keystore serverKeystore.jks;
