#! /bin/sh

echo "Stopping the WSO2 ESB..."
sudo service wso2-esb stop

echo "Stopping the PostgreSQL..."
sudo service postgresql stop

echo "Stopping the backend REST API..."
sudo kill -9 $(pidof java)

echo "Updating the project files..."
sudo git pull

echo "Starting the PostgreSQL..."
sudo service postgresql start

echo "Starting the WSO2 ESB..."
sudo service wso2-esb start

echo "Starting the backend REST API..."
sudo chmod +x ./gradlew
sudo ./gradlew bootRun &
