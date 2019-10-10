
### Crawler for github project's indicator
------

this project is aim for get the specified github project's indicators,  for example, watch, star, fork, issues,  and saved in mysql database,  provide with simple page to query the project indicators.


### usage

#### set application.properties

```properties

# schedule fetch github info
github.userId = taosdata
github.projectName = TDengine


spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&useSSL=false
spring.datasource.username=root
spring.datasource.password=root

```

#### RestFul 

**Query the latest github project indicator**

POST http://localhost:9090/github_crawler/github/{userId}/{projectName}

for example: `http://localhost:9090/github_crawler/github/taosdata/TDengine`

**query the github project indicator between startDate and endDate**

Get http://localhost:9090/github_crawler/github/{userId}/{projectName}/{startDate}/{endDate}

for example: `http://localhost:9090/github_crawler/github/taosdata/TDengine/20191001/20191010`


