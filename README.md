# Spring-helloword
Spring学习之旅dayone-HelloWord     

## day one
---------------------

* @Controller @RestController之区别：@RestController用来返回json字符串数据，@Controller用来指向一个web页面
* @RequestMapping 指定、设置路径映射地址
* @ResponseBody       


## day two
---------------------

**增加swagger2文档管理**        

### step1  
   在pom.xml中添加依赖
   ```
   		<dependency>
   			<groupId>io.springfox</groupId>
   			<artifactId>springfox-swagger2</artifactId>
   			<version>2.2.2</version>
   		</dependency>
   		<dependency>
   			<groupId>io.springfox</groupId>
   			<artifactId>springfox-swagger-ui</artifactId>
   			<version>2.2.2</version>
   		</dependency>
   ```     
        
### step2

   在Application同级包创建类`Swagger2.class`             
   
### step3
   
   在Controller的方法中添加注释，例如：
   >@ApiOperation(value="获取用户列表", notes="")
   ><br>@RequestMapping(value={""}, method=RequestMethod.GET)              
   
### step4
   运行项目，访问http://localhost:8080/swagger-ui.html                   
   
   
## day three
---------------------

### 连接JDBC数据库            

### step1 **添加依赖**            


```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.21</version>
        </dependency>
```

**添加jdbc配置文件**            

```
spring.datasource.url=jdbc:mysql://localhost:3306/test //test是数据库名称
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

### step2

编写service类，Impl类用@Service、@Autowired注解     
如果@Autowired使用时报错，解决办法如下：     
**Help**->**Edit Custom Property** 添加一行：     

```
idea.spring.boot.filter.autoconfig=false
```

