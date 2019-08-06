# PRODUCT INFORMATION MANAGEMENT
After pulling project, make install.sh executable
chmod 770 install.sh
to build the project you must have jdk and maven and docker
now run install.sh , 
./install.sh
this will build the code and build docker files and push into local docker repository and run docker-compose
Importer is avaiable at docker-host:8000
curl -X POST \
  http://docker-host:8000/import \
  -H 'cache-control: no-cache' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -F file=@dataExample.csv

file parameter contains name of uploaded file


Aggregator is avaiable at docker-host:8001
Endpoint to list all available products:  curl -X GET http://docker-host:8001/product/all 
Endpoint to show daily statistics : curl -X GET http://docker-host:8001/product/stat
