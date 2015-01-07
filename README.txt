--------------------------------------------------------------------------------
1/ CONFIGURATION DE "local_policy.jar"
--------------------------------------------------------------------------------
1) Récupérer l'archive "UnlimitedJCEPolicyJDK7.zip" à l'adresse suivante:
http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html

2) Télécharger l'archive "UnlimitedJCEPolicyJDK7.zip" dans le répertoire 
"java.home/lib/security/" 

3) Aller dans le répertoire "java.home/lib/security/"

4) Éxecuter cette suite de commande:
unzip "UnlimitedJCEPolicyJDK7.zip"; 
mv local_policy.jar local_policy.bak.jar; 
cp UnlimitedJCEPolicy/local_policy.jar ./; 
rm -r UnlimitedJCEPolicy.zip UnlimitedJCEPolicy/; 

commentaire:
java.home désigne le chemin du répertoire jre.
Par exemple, ~/Downloads/jdk1.7.0_71/jre.

--------------------------------------------------------------------------------
2/ COMMANDE DE LANCEMENT
--------------------------------------------------------------------------------
1) Lancer le registry:
cd registry/;
java -jar registry.jar ilfaitbeau cocolasticot

2) Lancer le server:
cd server/;
java -jar server.jar ilfaitbeau cocolasticot

3) Lancer le client:
cd client/;
java -jar server.jar ilfaitbeau cocolasticot hello
