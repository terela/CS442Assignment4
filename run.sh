#!/bin/bash +vx
#usage ./run <input> <output> <Num Iterations> <Debug Value>
#It assumes that build file placed in src/wordCount/build.xml
if test "$#" -ne 4; then
	echo "Wrong number of arguments!"
	echo "usage ./run <input> <output> <Num Iterations> <Debug Value>"
else
	echo "ant run -buildfile src/build.xml -Darg0=$1 -Darg1=$2 -Darg2=$3 -Darg3=$4"
	ant run -buildfile src/build.xml -Darg0=$1 -Darg1=$2 -Darg2=$3 -Darg3=$4
fi
