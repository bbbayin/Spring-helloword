# Spring-helloword
Spring学习之旅dayone-HelloWord     

## Day 1
----

* @Controller @RestController之区别：@RestController用来返回json字符串数据，@Controller用来指向一个web页面
* @RequestMapping 指定、设置路径映射地址
* @ResponseBody       


## Day 2
----

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
   
   
## Day 3
----

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

## Day 4
----

### 使用Spring-data-jpa     

**1.** 添加依赖    
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
```           

**2.** 配置application.properties           

```
spring.jpa.properties.hibernate.hbm2ddl.auto=create-drop
spring.data.jpa.repositories.enabled=true
```     

`hibernate.hbm2ddl.auto` 作用是：自动创建、更新、验证数据库表结构，值：
- **create**：每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。     
- **create-drop**：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。     
- **update** ：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等应用第一次运行起来后才会。               
- **validate** ：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。                 

**3.** 编写实体类      

   使用@Entiy，@Id，@Column等注解          
   
**4.**            
   编写xxRepository接口，继承JpaRepository，`JpaRepository` 自动实现了：创建（save）、更新（save）、删除（delete）、查询（findAll、                findOne）等操作，执行自定义的sql：             
```
    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
```       

**5. 特别要注意JpaRepository子类中方法的命名规则**  Spring-data-jpa的一大特性：通过解析方法名创建查询。
