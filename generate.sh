#!/bin/bash

# Check if a project name is provided
if [ -z "$1" ]; then
  echo "Usage: $0 <project-name>"
  exit 1
fi

PROJECT_NAME=$1
TEMPLATE_ZIP="template.zip"

# Check if the template zip file exists
if [ ! -f "$TEMPLATE_ZIP" ]; then
  echo "Error: $TEMPLATE_ZIP not found!"
  exit 1
fi

# Create the project directory
mkdir -p "$PROJECT_NAME"

# Unzip the template.zip into the project directory
unzip "$TEMPLATE_ZIP" -d "$PROJECT_NAME"

echo "Project '$PROJECT_NAME' created successfully from template."
