#!/bin/bash
echo '******Pulling from git'
git init
git pull https://github.com/farshadfalaki/pim.git
echo '******Building the entire project ...'
mvn clean package -DskipTests

echo '******Building docker files .....'
cd  ./modules/importer
docker build -t importer .
cd ../aggregator
docker build -t aggregator .

echo '******Going to run network via docker-compose .....'
docker-compose up
