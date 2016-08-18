# Swagger Demo

 ![Version](https://img.shields.io/badge/Version-0.0.6-blue.svg)

 ![jdk    ](https://img.shields.io/badge/Jdk-1.7+-blue.svg)
 ![Logger ](https://img.shields.io/badge/Logger-logback-green.svg)

 ![Spring ](https://img.shields.io/badge/Spring-4.2.5.RELEASE-blue.svg)
 ![SpringBoot ](https://img.shields.io/badge/SpringBoot-1.3.5.RELEASE-blue.svg)
 ![Springfox](https://img.shields.io/badge/Springfox-1.3.5.RELEASE-blue.svg)

**Branch:**

* [![Build](http://gitlab.mljr.com/mljr/hr/badges/master/build.svg)](http://gitlab.mljr.com/mljr/hr/commits/master) -  master
* [![Build](http://gitlab.mljr.com/mljr/hr/badges/develop/build.svg)](http://gitlab.mljr.com/mljr/hr/commits/develop) -  develop
* [![Build](http://gitlab.mljr.com/mljr/hr/badges/springboot-jar/build.svg)](http://gitlab.mljr.com/mljr/hr/commits/springboot) - spring-boot
* [![Build](http://gitlab.mljr.com/mljr/hr/badges/springboot-war/build.svg)](http://gitlab.mljr.com/mljr/hr/commits/springboot-war) -  spring-boot-war


**Author:**

 * NAME: LI JIAN
 * EMAIL: jian.li02@mljr.com

## 使用说明

具体代码请查看 demo-app-api

1. API 列表

   ![img](doc/images/1.png)

2. Form 表单提交数据库，使用对象接受数据

   ![img](doc/images/2.png)

3. Json 提交数据, 使用对象接受数据

   ![img](doc/images/3.png)

   提交结果

   ![img](doc/images/4.png)

4. 修改数据，使用 `@RequestParam`

   ![img](doc/images/5.png)
   ![img](doc/images/6.png)

5. 基于 Restful 规范的GET请求

   ![img](doc/images/7.png)

6. 上传文件

   ![img](doc/images/8.png)
   ![img](doc/images/9.png)

## 其他

* `springboot` 分支是直接jar运行
* `springboot-war` 是在springboot的基础上使用外置 tomcat 容器加载服务
* springmvc 项目请参考 springboot 项目进行修改，注意swagger的扫描，如:
   spring-mvc.xml
   ```xml
   <context:annotation-config />
   <mvc:default-servlet-handler/>
   <mvc:annotation-driven />
   <beans profile="dev">
      <context:component-scan base-package="springfox.documentation"/>
   </beans>
   ```
   springmvc控制变量`spring.profiles.active` 的值是通过web.xml中配置
   ```xml
   <context-param>
       <param-name>spring.profiles.active</param-name>
       <param-value>dev</param-value>
   </context-param>
   ```

