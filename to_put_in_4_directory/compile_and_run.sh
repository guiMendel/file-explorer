mkdir -p bin
javac -d bin -cp bin:graphics.jar $(find src -name '*.java' -print)
cd bin
java -cp .:../graphics.jar Main