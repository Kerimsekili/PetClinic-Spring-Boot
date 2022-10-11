# PetClinic-Spring-Boot
In this project, I am developing a Pet Clinic application using Spring Boot and Spring Technologies.In accordance with the multi-layered architecture and SOLID principles
.I used a lot of Spring-Boot capabilities while developing the project.This system includes authentication and authorization. Users can only perform transactions for which they are authorized.
Implementations of JPA; Transaction, Cache, Validation and Performance aspects have been implemented.The project includes CRUD operations

# Layers
### Dao: It is the layer that connects the project with the Database.
### Model : Our tables in the database have been created as objects in our project.
### Security : We keep the codes we write for database security and code security in this layer.
### Service : It is the service layer of our project. Various business rules; Data controls, validations and authorization controls.
### Web : Here we have the codes we made with web mvc that will communicate with the user. In our Controller classes, we check the results to be returned from the user and return the results to the user.

# In-app Images
### Login Page
![LoginPage](https://user-images.githubusercontent.com/65266777/195159409-b9c92720-deb3-4d39-845b-6a196a1ee989.png)

### Login Page Failed 
![LoginPageFailed](https://user-images.githubusercontent.com/65266777/195159571-3362b029-de66-4a62-9460-e25347ffad11.png)

### Success Login
![LoginSuccess](https://user-images.githubusercontent.com/65266777/195159748-1dfb64e8-4d03-4240-8d1e-1d2c59963e6a.png)

### Role Based Database
![RoleBasedDb](https://user-images.githubusercontent.com/65266777/195159814-3baf8598-e43b-4d9e-954e-0f346d7c5e7a.png)

### Listing Users
![OwnerCreated](https://user-images.githubusercontent.com/65266777/195160940-a46a8ec7-68bf-4fe5-9196-6245b78744d4.png)

### Owner Created Method and Mail Sender
![OwnerCreated](https://user-images.githubusercontent.com/65266777/195160834-0ad13bc1-2921-4b3f-bbc8-5217399282ae.png)

### Owner Update Method and Mail Sender
![updated](https://user-images.githubusercontent.com/65266777/195161157-14298454-f31c-43f3-be78-f6718af06640.png)

### Owner Delete Method and Mail Sender
![Deleted](https://user-images.githubusercontent.com/65266777/195161319-670d6d2a-672d-467f-94e9-89b91a06f2c5.png)



# Used Technologies
- Spring-Boot
- Spring-Boot Web MVC
- Spring Security
- Jsp
- Thymleaf 
- Caching
- REST API
- HATEOAS
- H-2 Database
- JDBC
- JPA/Hibernate
- Transaction
- Validation
- Authentication 
- UNIT TEST
- Data Repository
- E-mail sender(fakeSMTP)
- Logging
