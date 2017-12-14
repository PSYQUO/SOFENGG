@echo off

javac -Xlint:all -Xdiags:verbose -d bin src/*.java src/controller/*java src/controller/viewmanager/*java src/model/*java src/model/food/*java src/model/transaction/*java src/receipt/*java src/view/*java src/view/dialog/*java

cd bin
java App
cd ..
