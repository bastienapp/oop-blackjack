#!/usr/bin/env bash
clear
javac -cp out:lib/* -d out src/com/wildcodeschool/*.java 2> error.log
javac -cp out:lib/* -d out src/com/wildcodeschool/*/*.java 2> error.log
if [[ $(< error.log) != "" ]]; then
    cat error.log
else
    java -cp out:lib/* --module-path lib --add-modules javafx.controls com.wildcodeschool.Main
fi