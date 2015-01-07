#! /bin/bash

javac *.java;
jar -cfm ../server.jar MANIFEST.MF *.class;
