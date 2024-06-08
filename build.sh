#!/bin/bash
set -e

# Variables needed from Java
PWD=`pwd`
JDK_HOME="$PWD/jdk"
PATH="$JDK_HOME/bin:$PATH"
JAVA_HOME=$JDK_HOME
JRE_HOME="$JDK_HOME/jre"

# Build
javac -d bin/ $(find src -name '*.java')
