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
