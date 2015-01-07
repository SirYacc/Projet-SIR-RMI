#! /bin/bash

javac *.java;
jar -cfm ../registry.jar MANIFEST.MF *.class;
