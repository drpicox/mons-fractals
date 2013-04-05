#!/bin/sh



mkdir bin
javac -cp . mgc/mf/*.java
javac -cp . mgc/mf/filtre/*.java
javac -cp . mgc/mf/gui/*.java
javac -cp . mgc/mf/gui/filtre/*.java
