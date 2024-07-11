#!/bin/bash
# This script is used to sort the files inside the src dir according to its type

cd src; mkdir images documents others
for file in *
do
    if [[ $file == *.jpg  || $file == *.png || $file == *.gif ]] ;then
        mv "$file" images
        elif [[ $file == *.txt || $file == *.doc || $file == *.pdf ]] ;then
        mv "$file" documents
    else
        mv "$file" others
    fi
done


