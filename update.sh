#! /bin/sh

echo "Stopping the backend REST API..."
sudo service taxonomic-db stop

echo "Stopping the WSO2 ESB..."
sudo service wso2-esb stop

echo "Stopping the PostgreSQL..."
sudo service postgresql stop

echo "Updating the project files..."
sudo git pull

echo "Starting the PostgreSQL..."
sudo service postgresql start

echo "Starting the WSO2 ESB..."
sudo service wso2-esb start

echo "Starting the backend REST API..."
cd ./Backend
sudo chmod +x ./gradlew
sudo ./gradlew clean build
sudo service taxonomic-db start
