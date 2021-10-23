unit-testing

https://github.com/in28minutes/in28minutes-initiatives/blob/master/The-in28Minutes-TroubleshootingGuide-And-FAQ/quick-start.md

COURSE UPDATE : H2 Database URL With the latest versions of Spring Boot (2.3+), the H2 database name is randomly
generated each time you restart the server.

You can find the database name and URL from the console log.

RECOMMENDED:

Make the database URL a constant by configuring this in application.properties.

spring.datasource.url=jdbc:h2:mem:testdb spring.data.jpa.repositories.bootstrap-mode=default

DEBUGGING GUIDE (If you have problems)

JPA Hibernate Debugging
Guide: https://github.com/in28minutes/in28minutes-initiatives/blob/master/The-in28Minutes-TroubleshootingGuide-And-FAQ/jpa-and-hibernate.md

Why do we need to configure bootstrap-mode? Details here
- https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.3-Release-Notes#bootstrapmode-for-jpa-repositories


==================


(If you are using JUnit 5) In the next lecture, You do NOT need to add

@RunWith(SpringRunner.class) on top of

@DataJpaTest


==================


(If you are using JUnit 5) In the next lecture, You do NOT need to add

@RunWith(SpringRunner.class) on top of

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)