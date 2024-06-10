# spring-boot-rabbitmq-sample
Spring Boot RabbitMQ Sample

Send and receive messages from a Spring boot applications using RabbitMQ.

AMQP is the protocol used to allow communication between many applications through a RabbitMQ server. To support most
programming languages, connectors will enable you to interact with the server by exchanging messages with others
applications using your favorite programming language.

We will use the Spring dependency for RabbitMQ to make two Spring Boot applications communicate together.

### The use case

RabbitMQ is great for event-driven applications, which will act as the bridge to exchange information between
applications.

Let's say we are building a website application where the core back-end communicates with a notification service
responsible for emailing users. When a user register, we must send a confirmation email with a confirmation code. The
email sending should not block the response to the client.

The picture below shows the system architecture.

### Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-rabbitmq-sample.git`
2. Navigate to directory: `cd spring-boot-rabbitmq-sample`
3. Navigate to producer service: `cd producer`
4. Open new terminal then navigate to consumer service: 'cd consumer'
5. Run the application on each service: `mvn clean spring-boot:run`

### Send Queue

```shell
POST http://localhost:8080/register
Content-Type: application/json

{
  "name": "Itadori Yuji",
  "email": "yuji@yopmail.com"
}
```

### Console log

#### Producer Log

```shell
/Users/hendisantika/.sdkman/candidates/java/21-amzn/bin/java -XX:TieredStopAtLevel=1 -Dspring.output.ansi.enabled=always -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dmanagement.endpoints.jmx.exposure.include=* -javaagent:/Users/hendisantika/Applications/IntelliJ IDEA Ultimate.app/Contents/lib/idea_rt.jar=49954:/Users/hendisantika/Applications/IntelliJ IDEA Ultimate.app/Contents/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/hendisantika/IdeaProjects/spring-boot-rabbitmq-sample/producer/target/classes:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-starter-amqp/3.3.0/spring-boot-starter-amqp-3.3.0.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-starter/3.3.0/spring-boot-starter-3.3.0.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot/3.3.0/spring-boot-3.3.0.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.3.0/spring-boot-autoconfigure-3.3.0.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.3.0/spring-boot-starter-logging-3.3.0.jar:/Users/hendisantika/.m2/repository/ch/qos/logback/logback-classic/1.5.6/logback-classic-1.5.6.jar:/Users/hendisantika/.m2/repository/ch/qos/logback/logback-core/1.5.6/logback-core-1.5.6.jar:/Users/hendisantika/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.23.1/log4j-to-slf4j-2.23.1.jar:/Users/hendisantika/.m2/repository/org/apache/logging/log4j/log4j-api/2.23.1/log4j-api-2.23.1.jar:/Users/hendisantika/.m2/repository/org/slf4j/jul-to-slf4j/2.0.13/jul-to-slf4j-2.0.13.jar:/Users/hendisantika/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/Users/hendisantika/.m2/repository/org/yaml/snakeyaml/2.2/snakeyaml-2.2.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-messaging/6.1.8/spring-messaging-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-beans/6.1.8/spring-beans-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/amqp/spring-rabbit/3.1.5/spring-rabbit-3.1.5.jar:/Users/hendisantika/.m2/repository/org/springframework/amqp/spring-amqp/3.1.5/spring-amqp-3.1.5.jar:/Users/hendisantika/.m2/repository/org/springframework/retry/spring-retry/2.0.6/spring-retry-2.0.6.jar:/Users/hendisantika/.m2/repository/com/rabbitmq/amqp-client/5.21.0/amqp-client-5.21.0.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-context/6.1.8/spring-context-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-tx/6.1.8/spring-tx-6.1.8.jar:/Users/hendisantika/.m2/repository/io/micrometer/micrometer-observation/1.13.0/micrometer-observation-1.13.0.jar:/Users/hendisantika/.m2/repository/io/micrometer/micrometer-commons/1.13.0/micrometer-commons-1.13.0.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.3.0/spring-boot-starter-web-3.3.0.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.3.0/spring-boot-starter-json-3.3.0.jar:/Users/hendisantika/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.17.1/jackson-databind-2.17.1.jar:/Users/hendisantika/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.17.1/jackson-annotations-2.17.1.jar:/Users/hendisantika/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.17.1/jackson-core-2.17.1.jar:/Users/hendisantika/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.17.1/jackson-datatype-jdk8-2.17.1.jar:/Users/hendisantika/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.17.1/jackson-datatype-jsr310-2.17.1.jar:/Users/hendisantika/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.17.1/jackson-module-parameter-names-2.17.1.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.3.0/spring-boot-starter-tomcat-3.3.0.jar:/Users/hendisantika/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.24/tomcat-embed-core-10.1.24.jar:/Users/hendisantika/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.24/tomcat-embed-el-10.1.24.jar:/Users/hendisantika/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.24/tomcat-embed-websocket-10.1.24.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-web/6.1.8/spring-web-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-webmvc/6.1.8/spring-webmvc-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-aop/6.1.8/spring-aop-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-expression/6.1.8/spring-expression-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-configuration-processor/3.3.0/spring-boot-configuration-processor-3.3.0.jar:/Users/hendisantika/.m2/repository/org/projectlombok/lombok/1.18.32/lombok-1.18.32.jar:/Users/hendisantika/.m2/repository/org/slf4j/slf4j-api/2.0.13/slf4j-api-2.0.13.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-core/6.1.8/spring-core-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-jcl/6.1.8/spring-jcl-6.1.8.jar id.my.hendisantika.producer.ProducerApplication
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.0)

2024-06-10T07:03:09.821+07:00  INFO 16490 --- [producer] [           main] i.m.h.producer.ProducerApplication       : Starting ProducerApplication using Java 21 with PID 16490 (/Users/hendisantika/IdeaProjects/spring-boot-rabbitmq-sample/producer/target/classes started by hendisantika in /Users/hendisantika/IdeaProjects/spring-boot-rabbitmq-sample)
2024-06-10T07:03:09.823+07:00  INFO 16490 --- [producer] [           main] i.m.h.producer.ProducerApplication       : No active profile set, falling back to 1 default profile: "default"
2024-06-10T07:03:10.447+07:00  INFO 16490 --- [producer] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-06-10T07:03:10.454+07:00  INFO 16490 --- [producer] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-06-10T07:03:10.454+07:00  INFO 16490 --- [producer] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.24]
2024-06-10T07:03:10.474+07:00  INFO 16490 --- [producer] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-06-10T07:03:10.474+07:00  INFO 16490 --- [producer] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 598 ms
2024-06-10T07:03:10.868+07:00  INFO 16490 --- [producer] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-06-10T07:03:10.870+07:00  INFO 16490 --- [producer] [           main] o.s.a.r.c.CachingConnectionFactory       : Attempting to connect to: [rabbitmq.tericcabrel.com:5672]
2024-06-10T07:03:12.158+07:00  INFO 16490 --- [producer] [           main] o.s.a.r.c.CachingConnectionFactory       : Created new connection: rabbitConnectionFactory#29fa6b65:0/SimpleConnection@1e54a6b1 [delegate=amqp://admin@195.201.138.208:5672/, localPort=49969]
2024-06-10T07:03:12.178+07:00  INFO 16490 --- [producer] [           main] i.m.h.producer.ProducerApplication       : Started ProducerApplication in 2.8 seconds (process running for 3.383)
2024-06-10T07:03:19.559+07:00  INFO 16490 --- [producer] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-06-10T07:03:19.559+07:00  INFO 16490 --- [producer] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-06-10T07:03:19.560+07:00  INFO 16490 --- [producer] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2024-06-10T07:03:20.010+07:00  INFO 16490 --- [producer] [nio-8080-exec-1] i.m.h.p.controller.UserController        : User registered successfully!

```

#### Consumer Log

Consumer Log

```shell
/Users/hendisantika/.sdkman/candidates/java/21-amzn/bin/java -XX:TieredStopAtLevel=1 -Dspring.output.ansi.enabled=always -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dmanagement.endpoints.jmx.exposure.include=* -javaagent:/Users/hendisantika/Applications/IntelliJ IDEA Ultimate.app/Contents/lib/idea_rt.jar=50550:/Users/hendisantika/Applications/IntelliJ IDEA Ultimate.app/Contents/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/hendisantika/IdeaProjects/spring-boot-rabbitmq-sample/consumer/target/classes:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-starter-amqp/3.3.0/spring-boot-starter-amqp-3.3.0.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-starter/3.3.0/spring-boot-starter-3.3.0.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.3.0/spring-boot-starter-logging-3.3.0.jar:/Users/hendisantika/.m2/repository/ch/qos/logback/logback-classic/1.5.6/logback-classic-1.5.6.jar:/Users/hendisantika/.m2/repository/ch/qos/logback/logback-core/1.5.6/logback-core-1.5.6.jar:/Users/hendisantika/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.23.1/log4j-to-slf4j-2.23.1.jar:/Users/hendisantika/.m2/repository/org/apache/logging/log4j/log4j-api/2.23.1/log4j-api-2.23.1.jar:/Users/hendisantika/.m2/repository/org/slf4j/jul-to-slf4j/2.0.13/jul-to-slf4j-2.0.13.jar:/Users/hendisantika/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/Users/hendisantika/.m2/repository/org/yaml/snakeyaml/2.2/snakeyaml-2.2.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-messaging/6.1.8/spring-messaging-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-beans/6.1.8/spring-beans-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/amqp/spring-rabbit/3.1.5/spring-rabbit-3.1.5.jar:/Users/hendisantika/.m2/repository/org/springframework/amqp/spring-amqp/3.1.5/spring-amqp-3.1.5.jar:/Users/hendisantika/.m2/repository/org/springframework/retry/spring-retry/2.0.6/spring-retry-2.0.6.jar:/Users/hendisantika/.m2/repository/com/rabbitmq/amqp-client/5.21.0/amqp-client-5.21.0.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-context/6.1.8/spring-context-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-aop/6.1.8/spring-aop-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-expression/6.1.8/spring-expression-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-tx/6.1.8/spring-tx-6.1.8.jar:/Users/hendisantika/.m2/repository/io/micrometer/micrometer-observation/1.13.0/micrometer-observation-1.13.0.jar:/Users/hendisantika/.m2/repository/io/micrometer/micrometer-commons/1.13.0/micrometer-commons-1.13.0.jar:/Users/hendisantika/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.17.1/jackson-databind-2.17.1.jar:/Users/hendisantika/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.17.1/jackson-annotations-2.17.1.jar:/Users/hendisantika/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.17.1/jackson-core-2.17.1.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-devtools/3.3.0/spring-boot-devtools-3.3.0.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot/3.3.0/spring-boot-3.3.0.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.3.0/spring-boot-autoconfigure-3.3.0.jar:/Users/hendisantika/.m2/repository/org/springframework/boot/spring-boot-configuration-processor/3.3.0/spring-boot-configuration-processor-3.3.0.jar:/Users/hendisantika/.m2/repository/org/projectlombok/lombok/1.18.32/lombok-1.18.32.jar:/Users/hendisantika/.m2/repository/org/slf4j/slf4j-api/2.0.13/slf4j-api-2.0.13.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-core/6.1.8/spring-core-6.1.8.jar:/Users/hendisantika/.m2/repository/org/springframework/spring-jcl/6.1.8/spring-jcl-6.1.8.jar id.my.hendisantika.consumer.ConsumerApplication
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.0)

2024-06-10T07:04:48.839+07:00  INFO 16589 --- [consumer] [  restartedMain] i.m.h.consumer.ConsumerApplication       : Starting ConsumerApplication using Java 21 with PID 16589 (/Users/hendisantika/IdeaProjects/spring-boot-rabbitmq-sample/consumer/target/classes started by hendisantika in /Users/hendisantika/IdeaProjects/spring-boot-rabbitmq-sample)
2024-06-10T07:04:48.840+07:00  INFO 16589 --- [consumer] [  restartedMain] i.m.h.consumer.ConsumerApplication       : No active profile set, falling back to 1 default profile: "default"
2024-06-10T07:04:48.857+07:00  INFO 16589 --- [consumer] [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2024-06-10T07:04:49.247+07:00  INFO 16589 --- [consumer] [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2024-06-10T07:04:49.276+07:00  INFO 16589 --- [consumer] [  restartedMain] o.s.a.r.c.CachingConnectionFactory       : Attempting to connect to: [rabbitmq.tericcabrel.com:5672]
2024-06-10T07:04:50.559+07:00  INFO 16589 --- [consumer] [  restartedMain] o.s.a.r.c.CachingConnectionFactory       : Created new connection: rabbitConnectionFactory#1bdf2afb:0/SimpleConnection@709c2e48 [delegate=amqp://admin@195.201.138.208:5672/, localPort=50560]
2024-06-10T07:04:51.784+07:00  INFO 16589 --- [consumer] [  restartedMain] i.m.h.consumer.ConsumerApplication       : Started ConsumerApplication in 3.297 seconds (process running for 3.809)
Message received
User full name:    Itadori Yuji
Email Address:     yuji@yopmail.com
Confirmation code: 786509
Message received
User full name:    Itadori Yuji
Email Address:     yuji@yopmail.com
Confirmation code: 188338

```
