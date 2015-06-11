#!/usr/bin/env bash

cd /opt

git clone -b prod https://github.com/unepwcmc/Taxonomic-Database-Application.git

cd ./Taxonomic-Database-Application
#Update script for new releases
sudo chmod +x update.sh

#Run the Rest API
cd ./Backend
sudo chmod +x gradlew
sudo ./gradlew bootRun &
