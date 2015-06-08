#!/usr/bin/env bash

#Update and begin installing some utility tools
sudo apt-get -y update
sudo apt-get install -y python-software-properties
sudo apt-get -y update
sudo apt-get install -y git-core subversion curl
sudo apt-get install -y unzip
sudo apt-get install -y chkconfig

#Install Java
sudo /vagrant/scripts/java.sh

#Install PostgreSQL
sudo /vagrant/scripts/postgres.sh

#Install WSO2
sudo /vagrant/scripts/wso2-esb.sh

#Install Taxonomic DB
sudo /vagrant/scripts/taxonomic-db.sh
