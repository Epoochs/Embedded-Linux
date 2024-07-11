#!/bin/bash
# This script is used to sort the files inside the src dir according to its type

# It will create a new folder for each type of file and move the files inside the src dir
cd src; mkdir "images" "documents" "others"

for file in *
do
    if [[ $file == *.jpg  || $file == *.png || $file == *.gif ]] ;then
        mv "$file" "images"
        elif [[ $file == *.txt || $file == *.doc || $file == *.pdf ]] ;then
        mv "$file" "documents"
    else
        if ! [ -d "$file" ]; then
            mv "$file" "others"
        fi
    fi
done


