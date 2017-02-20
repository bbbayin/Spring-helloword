# Spring-helloword
Spring学习之旅dayone-HelloWord

####day one
--

* @Controller @RestController之区别：@RestController用来返回json字符串数据，@Controller用来指向一个web页面
* @RequestMapping 指定、设置路径映射地址
* @ResponseBody


####day two
--

####增加swagger2文档管理
###step1  
   在pom.xml中添加依赖
>   		<dependency>
>   			<groupId>io.springfox</groupId>
>   			<artifactId>springfox-swagger2</artifactId>
>   			<version>2.2.2</version>
>   		</dependency>
>   		<dependency>
>   			<groupId>io.springfox</groupId>
>   			<artifactId>springfox-swagger-ui</artifactId>
>   			<version>2.2.2</version>
>   		</dependency>

### step2

   在Application同级包创建类`Swagger2.class`
   
### step3
   
   在Controller的方法中添加注释，例如：
   >@ApiOperation(value="获取用户列表", notes="")
   ><br>@RequestMapping(value={""}, method=RequestMethod.GET)
   
### step4
   运行项目，访问http://localhost:8080/swagger-ui.html

