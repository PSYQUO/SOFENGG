@echo off

javac -d bin -Xlint:all -Xdiags:verbose src/*.java src/view/*.java src/receipt/*.java src/model/*.java src/model/transaction/*.java src/controller/*.java src/controller/ViewManager/*.java

cd bin
java App
cd ..