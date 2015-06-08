#!/usr/bin/env bash
cd /opt

git clone https://integritas-rodrigosilva:Epedod45@github.com/unepwcmc/Taxonomic-Database-Application.git

cd ./Taxonomic-Database-Application/Backend

#Run the Rest API
sudo chmod +x gradlew
sudo ./gradlew bootRun --daemon
