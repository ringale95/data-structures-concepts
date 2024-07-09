#!/bin/bash

SOURCE_DIR="/code/allAboutJava/princeton-algorithms/client/modules"
DEST_DIR="/Desktop/ingale95.github.io"


cd "$SOURCE_DIR"

for f in *.html
do 
   cp -v "$f" "$DEST_DIR/${f%.html}$(date +%m%d%y).html"
done

cd "$DEST_DIR"
git add .
git commit -m "done"
git push origin main
