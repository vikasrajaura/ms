- Initialize local directory as git repo
- create github repo like - ms
- Add remote in - manage remote options in intellij

https://start.spring.io/

1. Create discovery-server or service-registry
	a. Add - eureka server as a discovery server in pom dependencies, download and import in intellij
	b. @EnableEurekaServer on main application class
	c. application.yml changes
server:
  port: 8761

spring:
  application:
    name: DISCOVERY-SERVER

eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

2. Create cloud-gateway or api-gateway
	a. Add - spring-cloud-routing gateway, actuator, eureka discovery client in pom dependencies, download and import in intellij
	b. @EnableDiscoveryClient on main application class
	c. application.yml changes
server:
  port: 9191

spring:
  application:
    name: CLOUD-GATEWAY
  cloud:
    gateway:
      routes:
        - id: PRODUCT-SERVICE
          uri: lb://PRODUCT-SERVICE
          predicates:
            - Path=/products/**
eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8761/eureka

3. Create config-Server
   	a. Add - spring-cloud-config-server, eureka discovery client in pom dependencies, download and import in intellij
   	b. @EnableConfigServer, @EnableDiscoveryClient on main application class
   	c. application.yml changes -
   	d. create local or remote git repo, and add application.yml file there, add below config in that yml file
   	    eureka:
          client:
            register-with-eureka: true
            fetch-registry: true
            service-url:
              defaultZone: http://localhost:8761/eureka;
          instance:
            hostname: localhost
    e. add below config in config server yml file, here we have created local git repo
   	    server:
          port: 8088

        spring:
          application:
            name: CONFIG-SERVER
          profiles:
            active: native
          cloud:
            config:
              server:
                git:
                  uri: file:\\D:/dev/proj/java/config-server-repo
                  clone-on-start: true

    f. Now other services need to talk to this config-server, so that configurations can be read, for that
        we need to include starter-config dependency in pom.xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-config</artifactId>
		</dependency>
	g. And Add below config in application.yml file
	     config:
           import: configserver:http://localhost:8088

4. Hystrix - to make resilence app and to add fallback controller, add this in cloud-gateway.
	a. Add hystrix dependency in pom
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
		</dependency>
	b. @EnableHystrix on cloud-gateway main application class
	c. Add FallbackController in cloudgateway
