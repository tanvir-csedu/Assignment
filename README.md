
Project Name: TaskManagement

Developer Name: Tanvir Ahmed

Framework Used: Spring, Hibernate

Database: MySQL

Tools: Maven

------------------------------------------ How It works------------------------------------------

Configuration:
As we know in in the maven project there is a POM file that contains the library that required for the project. In my pom.xml file I provide all the dependency library of Spring, Hibernate, mysql.

Then I define the sarvlet file named spring-servlet.xml and jdbc.properties file. In those file I define the mysql connection properties, hibernate connection properties and spring properties.

Working Procedure:
Then I define a controller in the TaskController.java file. And I map all the URL in there. I provide /tasks URL in the controller by which I get all the task list of the system. But in further development it is possible to do one-to-many mapping with the user to tasks.

I also define some other URL like /AddUpdateTask to add or edit a task. Then I define /DeleteTask/{taskId} URL to delete a task.

Also I define a JSP page called task.jsp for CRUD operation for task management. For getting faster output I use JAVAScript to load a task that need to be edited.

I also define a DAO class and interface class for the CRUD operation in the database. When someone submit a request a new instance of TaskService is created(becuase of autowiring) and call the corresponding method of TaskServiceImplementation. Then a TaskDAO instance is created which do the original operation for the request and either save/retrive from the database.




