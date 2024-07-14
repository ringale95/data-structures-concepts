#!/bin/bash

SOURCE_DIR="/Users/ingale.r/code/allAboutJava/princeton-algorithms/client/modules"
DEST_DIR="/Users/ingale.r/Desktop/ringale95.github.io"

cd "$SOURCE_DIR"
cp -r ./** $DEST_DIR

cd "$DEST_DIR"
git pull origin main
git add .
git commit -m "done"
git push origin main
