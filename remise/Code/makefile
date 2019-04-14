# File: makefile

.SUFFIXES:
.SUFFIXES: .java .class

all:build	run

build:
	cd GenieK && echo "updating source list..." && find -name "*.java" > source.txt && echo "building class files..." && javac -d build @source.txt && cd .. && echo "Done!"

run:
	java -cp GenieK/build/ ui/SystemMain

buildjar:clean	build
	cd GenieK && echo "updating class list..." && echo "deflating files to jar..." && jar -cfm artifacts/GestionReservation.jar Manifest.txt -C build . && cd .. && echo "Done!"

updatejar:
	cd GenieK && echo "updating class list..." && echo "updating jar..." && jar -ufm artifacts/GestionReservation.jar Manifest.txt -C build . && cd .. && echo "Done!"

runjar:
	java -jar GenieK/artifacts/GestionReservation.jar

clean:
	rm -r -f GenieK/build/* && echo "build directory successfully cleaned!" 

