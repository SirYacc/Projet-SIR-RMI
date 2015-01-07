#! /bin/bash

javac *.java;
jar -cfm ../client.jar MANIFEST.MF *.class;
