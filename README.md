# PRODUCT INFORMATION MANAGEMENT
### Introduction
In a dynamic online shop, there must be a way of merchants adding/updating
products in the backend. There are two separate microservices serving this purpose:
Firt one to read products data from a CSV file (Importer) and wrap them into a JSON
object for the other service to consume.
The second one to save and maintain the product data received and provide some statistics about them (Aggregator) .
### Prerequisites
To compile and run the project, the following tools should be installed:

+ JDK 8+
+ Maven
+ Docker , Docker-compose
### Installing
After pulling project, make install.sh executable
chmod 770 install.sh
to build the project now run install.sh
```
./install.sh
```
this will build the code and build docker files and push into local docker repository and run docker-compose
###Importer
Importer is avaiable at docker-host:8000
```
curl -X POST \
  http://docker-host:8000/import \
  -H 'cache-control: no-cache' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -F file=@dataExample.csv
```  
file parameter contains name of uploaded file

###Aggregator
Aggregator is avaiable at docker-host:8001
Endpoint to list all available products:  
```
curl -X GET http://docker-host:8001/product/all 
```
Endpoint to show daily statistics : 
```
curl -X GET http://docker-host:8001/product/stat
```
### Author
  Farshad Falaki
