# graphql



##### build code and docker images :
```
mvn clean install docker:build 
```

#### how to run example:


##### start containers :

```
docker-compose -f docker-compose.yml up -d
```

 ##### stop containers :

 ```
docker-compose -f docker-compose.yml stop
```

 ##### remove containers :
  
```
docker-compose -f docker-compose.yml rm -f   
```


#### Get All authors

```
    URL : http://localhost:8080/query

    Method : POST 
    
    Content: 
            {
              authors{
                 id
                 firstName
                 lastName
              }
            }
   
```
#### Get authors by id


```
    URL : http://localhost:8080/query

    Method : POST 
    
    Content: 
           {
             author(id: "3c866ee6-3f0a-45ba-806a-7405446743b2"){
                id
                firstName
                lastName
             }
           }
   
```

