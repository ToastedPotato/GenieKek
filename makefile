# File: makefile

.SUFFIXES:
.SUFFIXES: .java .class

all:build	run

build:
	cd GenieK && echo "building class files..." && javac -d build @source.txt && cd .. && echo "Done!"

run:
	java -cp GenieK/build/ Main

clean:
	rm -r -f GenieK/build/* && echo "build directory successfully cleaned!" 

