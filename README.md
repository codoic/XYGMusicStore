XYGMusicStore
=============

A Java EE based web application that allows online selling. The project demonstrates simple use of Jave EE technology, Glassfish Server and Primefaces framework.  

###Targeted Audiences
This project is for beginners learning their first Java EE application. It was done as part of university project for learning - Object Relational Mapping (ORM), Stateless & Stateful Session Beans, java messaging service, web services and Java Server Faces (JSF).     

###1. Introduction
XYG Music is a music company who is looking to build an E-commerce web application. The main objective of developing this product is to increase the consumers for business by being able to sell music CD’s online. The product developed also provides other feature according to requirements which is discussed in this document.  The solution is a web based portal. 

###1.1 Project Scope
The scope of this project is to design and develop a web application that allows users to buy CD through a web based portal. 

###2. Product Features
1. Login for different access level: The system shall be integrated with secure login using Java EE technology. 
	- Customers: The customers are general users who would like to perform online shopping. They will have general rights and are able shop in the online store.  
	- Admin access: Admin login shall be given to administrative staff. They are able to add, edit, delete stocks from catalogue and track an order by a customer.  

2. Sign up for online shopping: This functionality is available to all users who want to register for online shopping. Users will need to provide registration detail to sign up. 

3. Catalogue browsing: The user who has signed up for online shopping will be able to browse through the catalogue provided by XYG Music.   

4. Cart item: The logged in user is able to add items to cart. They are also able to modify item and delete all items from the cart. 

5. Checkout: After the shopping is completed, user will be able to checkout. The total amount of item will be displayed to user and admin staffs are able to keep track of ordered items.      

6. Change details: Users are able to change their detail which was provided while signing up for online shopping. 

7. Maintain Catalogue: Admin staffs are able to maintain items in catalogue. They are able to add new item in catalogue, and remove items from catalogue.  

8. Exchange catalogue: Admin staffs are able to exchange their catalogue to a different branch located in different state.     

###3. Operating Environment
The Application is a web-based application so the minimum requirements are as follows:
• Server Side:
  - Glassfish Server 3
  - JAVA DB which comes bundled Glassfish3

• Client Side
  - Web-browser that supports java.    

###4. Assumptions and Dependencies
  • The application will only be deployed in testing machine and will not focus in testing in different machines considering the limited timeframe.
  • Payment processing i.e deducting amount from customer’s bank account will not be covered in this project. 
  • User Interface and templates will not be focused as part of this project. 
