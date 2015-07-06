#! /bin/sh

cd /opt/Taxonomic-Database-Application/

echo "Stopping the WSO2 ESB..."
sudo service wso2-esb stop

echo "Stopping the PostgreSQL..."
sudo service postgresql stop

echo "Stopping the frontend..."
sudo service taxonomic-web stop

echo "Stopping the backend REST API..."
sudo service taxonomic-db stop 

echo "Updating the project files..."
sudo git pull

echo "Starting the PostgreSQL..."
sudo service postgresql start

echo "Starting the WSO2 ESB..."
sudo service wso2-esb start

echo "Starting the backend REST API..."
cd ./Backend
sudo chmod +x ./gradlew
sudo ./gradlew build -x test 
sudo service taxonomic-db start

echo "Starting the frontend..."
sudo service taxonomic-web start  
