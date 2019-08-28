WEB-APPLICATION

Need to create a web-application which allows:
1. Perform user registration
2. Perform user authorisation
3. Perform CRUD operations on next objects:
----------------------
Product:

•	UUID;
•	Name;
•	BigDecimal price;
•	Manufacturer;
----------------------
Manufacturer:

•	UUID;
•	Name;
•	Products <Product>;
----------------------
Role:

•	UUID;
•	Name;
----------------------
User:

•	UUID;
•	email;
•	String password;
•	firstName;
•	lastName;
•	Roles <Role>;
----------------------
User roles:
1. Admin - is able to perform all CRUD operations
2. User - has read-only access

Data about Manufacturers and Products is stored in DB.
Every Product has one Manufacturer and every Manufacturer has a bunch of Products.

It is necessary to follow the MVC pattern (model, view, controller).

Technology stack:
Java, SQL, Spring (MVC, Data, Security, Spring Boot), JSP or (HTML/CSS), Maven, Tomcat, Git
