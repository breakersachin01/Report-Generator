# Report Generator

## Overview
The Report Generator is a Java-based Maven project designed to manage and generate reports for student records. It utilizes JDBC for MySQL as the backend database and demonstrates the use of Object-Oriented Programming (OOP) concepts such as polymorphism (function overloading) and data abstraction. The project also leverages the iText library to create PDFs of student reports, detailing their marks and other information. The entire GUI is implemented using Swing JFrame, providing a single-window interface for all operations.

## Features
-**Authorization**
<img src="https://github.com/Javed0-786/PrivacyPolicyKnoWow/blob/main/Report%20Generator/Login%20Window.png" alt="Screenshot 0"/>
- **Add Student Records**: Allows adding new student records through the GUI.
- <img src="https://github.com/Javed0-786/PrivacyPolicyKnoWow/blob/main/Report%20Generator/Add%20New%20Student.png" alt="Screenshot 1"/>
- **Upload Image**: Student picture is uploaded.
- <img src="https://github.com/Javed0-786/PrivacyPolicyKnoWow/blob/main/Report%20Generator/Upload%20Image.png" alt="Screenshot 5"/>
- **Update Student Records**: Provides functionality to update existing student records.
- <img src="https://github.com/Javed0-786/PrivacyPolicyKnoWow/blob/main/Report%20Generator/Successfully%20Added.png" alt="Screenshot 2"/>
- **Delete Student Records**: Enables deletion of student records from the database.
- <img src="https://github.com/Javed0-786/PrivacyPolicyKnoWow/blob/main/Report%20Generator/Delete%20Record.png" alt="Screenshot 3" />
- **Feed Student Marks**: Feed the marks of students based on their courses they are enrolled in, the courses are fetched from the database based on department of the student which is fetched based on the primary key student registration number.
- <img src="https://github.com/Javed0-786/PrivacyPolicyKnoWow/blob/main/Report%20Generator/Marks%20Feed.png" alt="Screenshot 6"/>
- **View and Download Reports**: Generates a PDF report of student marks and details, which can be downloaded.
- <img src="https://github.com/Javed0-786/PrivacyPolicyKnoWow/blob/main/Report%20Generator/Show%20Student%20Marks.png" alt="Screenshot 4" width="400" />
- **Report Donloaded**: The pdf of the report of the student is generated using iTextPDF.
- <img src="https://github.com/Javed0-786/PrivacyPolicyKnoWow/blob/main/Report%20Generator/Pdf%20Downloaded.png" alt="Screenshot 7" />

- **Database Operations**: Utilizes SQL joins, primary keys, and foreign keys for efficient database management.
- <img src="https://github.com/Javed0-786/PrivacyPolicyKnoWow/blob/main/Report%20Generator/Database%201.png" alt="Screenshot 8" />
- <img src="https://github.com/Javed0-786/PrivacyPolicyKnoWow/blob/main/Report%20Generator/Database%201.png" alt="Screenshot 9" />

## Technologies Used
- **Java**
- **Maven**
- **JDBC (Java Database Connectivity)**
- **MySQL**
- **iText PDF**
- **Swing (JFrame)**

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
