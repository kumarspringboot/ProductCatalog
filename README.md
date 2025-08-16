[![Watch the employee registration video](https://raw.githubusercontent.com/kumarspringboot/ProductCatalog/master/thumbnail.jpg)](https://raw.githubusercontent.com/kumarspringboot/ProductCatalog/master/emplRegister.mp4)
[![Watch the login page video] (https://github.com/kumarspringboot/ProductCatalog/raw/refs/heads/master/loginpage.mp4)

**#created emplregister.html
#created [EmployeeEntity.java](src/main/java/com/alt/entity/EmployeeEntity.java) 
#created [EmployeeDTO.java](src/main/java/com/alt/dto/EmployeeDTO.java)
#created [EmployeeRepository.java](src/main/java/com/alt/repository/EmployeeRepository.java)
#created [EmployeeService.java](src/main/java/com/alt/service/EmployeeService.java)
**


**first time when loaded got follwoing error:
**org.thymeleaf.exceptions.TemplateInputException: An error happened during template parsing (template: "class path resource [templates/emplregister.html]")

Caused by: org.attoparser.ParseException: Error during execution of processor 'org.thymeleaf.spring6.processor.SpringInputRadioFieldTagProcessor' (template: "emplregister" - line 31, col 37)
Caused by: org.thymeleaf.exceptions.TemplateProcessingException: Error during execution of processor 'org.thymeleaf.spring6.processor.SpringInputRadioFieldTagProcessor' (template: "emplregister" - line 31, col 37)
Caused by: org.springframework.core.convert.ConversionFailedException: Failed to convert from type [java.lang.String] to type [int] for value [Male]
2025-08-16T09:16:46.002+05:30 ERROR 16680 --- [ProductCatalog] [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: org.thymeleaf.exceptions.TemplateInputException: An error happened during template parsing (template: "class path resource [templates/emplregister.html]")] with root cause

**typo 
gender was int in Entity and DTO. both places changed to String.
**this is redundancy.



**once i open got following error:
**Sat Aug 16 09:27:00 IST 2025
**There was an unexpected error (type=Bad Request, status=400).
**Validation failed for object='employee'. Error count: 2
**org.springframework.web.bind.MethodArgumentNotValidException: Validation failed for argument [0] in public java.lang.String com.alt.controller.EmployeeController.saveEmployee(com.alt.dto.EmployeeDTO,org.springframework.ui.Model) with 2 errors: [Field error in object 'employee' on field 'email': rejected value [kumar@gmail.com]; codes 
**



**received following error:
**Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Sat Aug 16 09:28:01 IST 2025
There was an unexpected error (type=Internal Server Error, status=500).
**Cannot invoke "com.alt.service.EmployeeService.registerEmployee(com.alt.dto.EmployeeDTO)" because "this.employeeService" is null
**java.lang.NullPointerException: Cannot invoke "com.alt.service.EmployeeService.registerEmployee(com.alt.dto.EmployeeDTO)" because "this.employeeService" is null

2025-08-16T09:33:20.839+05:30 ERROR 7356 --- [ProductCatalog] [nio-8080-exec-7] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.lang.NullPointerException: Cannot invoke "com.alt.service.EmployeeService.registerEmployee(com.alt.dto.EmployeeDTO)" because "this.employeeService" is null] with root cause

java.lang.NullPointerException: Cannot invoke "com.alt.service.EmployeeService.registerEmployee(com.alt.dto.EmployeeDTO)" because "this.employeeService" is null
at com.alt.controller.EmployeeController.saveEmployee(EmployeeController.java:25) ~[classes/:na]
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]



**noticed that autowired was missing in [EmployeeController.java](src/main/java/com/alt/controller/EmployeeController.java)
@Autowired
private EmployeeService employeeService;
**
