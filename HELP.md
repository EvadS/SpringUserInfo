# Getting Started

##How to run 

### step 1. Build maven project 
```bash
mvn clean package -DskipTests
```
### step 2. Build docker image 
```bash
    docker build .   
```
### step 3. Run docker -compose
```bash    
    docker-compose up -d 
```
### step 4. Check on swagger 
```http request
http://localhost:8000/swagger-ui.html
```