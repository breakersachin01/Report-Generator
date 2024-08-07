# Report Card Management System

## Overview
Solely developed a comprehensive Student Result Management System using a full-stack approach. 
Utilized JavaServer Pages (JSP) for dynamic content generation, HTML for markup, CSS for styling, and 
JavaScript for client-side interactivity, demonstrating proficiency in front-end web development 
technologies. 
Integrated front-end components seamlessly with back-end functionality using Eclipse IDE, Apache 
Tomcat server, and MySQL database. Created a cohesive and scalable application, demonstrating the ability 
to independently architect, develop, and deploy end-to-end web solutions.

## Features
-**HomePage**
<img src="https://github.com/breakersachin01/Advance-Java-Project/blob/main/01HomePage.png" alt="Screenshot 0"/>
- **Search Student Records**: Allows to print the records in the formate of word or pdf using iTextPDF.
- <img src="https://github.com/breakersachin01/Advance-Java-Project/blob/main/02Search-RollNo.png" alt="Screenshot 1"/>
- **Show Student Record**: 
- <img src="https://github.com/breakersachin01/Advance-Java-Project/blob/main/03Student-Report-Card%20page.png" alt="Screenshot 5"/>
- <img src="https://github.com/breakersachin01/Advance-Java-Project/blob/main/04PrintReport.png"/>
- **Admin Login**: Provides functionality to update existing student records.
- <img src="https://github.com/breakersachin01/Advance-Java-Project/blob/main/05Admin-LogIn.png" alt="Screenshot 2"/>
- **Delete Student Records**: Enables deletion of student records from the database.
- <img src="https://github.com/breakersachin01/Advance-Java-Project/blob/main/06update-record.png" alt="Screenshot 3" />
- **Feed Student Marks**: Feed the marks of students based on their courses they are enrolled in, the courses are fetched from the database based on department of the student which is fetched based on the primary key student registration number.

- **Wrong Username-password**: Admin enter Wrong Username or password.
- <img src="https://github.com/breakersachin01/Advance-Java-Project/blob/main/07Incorrect%20Username-password.png" alt="Screenshot 7" />

## Technologies Used
- **Java**
- **Maven**
- **JDBC (Java Database Connectivity)**
- **MySQL**
- **iText PDF**
- **HTML, CSS, JavaScript**

## OOP Concepts
- **Polymorphism (Function Overloading)**
- **Data Abstraction**

## Installation and Setup
1. **Clone the Repository**:
    ```bash
    git clone https://github.com/breakersachin01/Report-Generator
    cd report-generator
    ```

2. **Setup Database**:
    - Create a MySQL database.
    - Import the provided SQL script to set up the tables and relationships.

3. **Configure Database Connection**:
    - Update the database configuration in the project to match your MySQL database settings.

4. **Build the Project**:
    ```bash
    mvn clean install
    ```

5. **Run the Application**:
    ```bash
    java -jar target/report_generator-1.0-SNAPSHOT.jar
    ```

## Usage
- **Login Window**: Start the application and login using your credentials.
- **Add Student**: Navigate to the 'Add Student' section to add new student records.
- **Update/Delete Student**: Use the 'Manage Students' section to update or delete existing records.
- **View Marks**: Navigate to the 'View Marks' section to view student marks and download PDF reports.

## GUI Components
- **Main Login Window**: The initial window for user login.
- **Single Window Interface**: All functionalities (add, update, delete, view) are accessible through a single window interface.

## Example Code Snippets
### Main.java
```java
package com.example;

public class Main {
    public static void main(String[] args) {
        MainLoginWindow login = new MainLoginWindow();
        login.setVisible(true);
    }
}
