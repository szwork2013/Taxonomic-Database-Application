#!/usr/bin/env bash

cd /opt

git clone -b release https://github.com/unepwcmc/Taxonomic-Database-Application.git

cd ./Taxonomic-Database-Application
#Update script for new releases
sudo chmod +x update.sh

#Run the Rest API
cd ./Backend
sudo chmod +x gradlew
sudo ./gradlew build

#Installing the backend application as Linux service
#sudo cp /vagrant/config/spring-boot /etc/init.d/taxonomic-db
#sudo chmod 755 /etc/init.d/taxonomic-db
#sudo chkconfig --add taxonomic-db
#sudo mkdir /var/log/taxonomic-db
cd ./build/libs
sudo link -s ./taxonomic-db-spring-boot-0.0.1.SNAPSHOT.jar /etc/init.d/taxonomic-db
sudo chmod 755 /etc/init.d/taxonomic-db
sudo chkconfig --add taxonomic-db

service taxonomic-db start
