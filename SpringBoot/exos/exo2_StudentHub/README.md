# StudentHub Application: Java Spring MVC

## Student Management System

- Implements CRUD operations with restcontroller and controller  
- Simulates a database in StudentService 

### Description:

This is a web application designed to manage students. It provides the following functionalities:

- Creating a student (including fields: name, surname, age, email)
- Listing all students (only displaying name and surname)
- Searching for a student by name
- Viewing detailed information of a student

### Pages:

The application consists of several web pages:

1. **Home**: 
   - Provides navigation to other pages: 
     - List of students
     - Registration page
     - Student search

2. **Registration**: 
   - Allows users to fill out a form to register a new student
   - Upon submission, redirects to the student list page
   - Includes a link to return to the home page

3. **Student List**: 
   - Displays a list of all students (only name and surname)
   - Provides a "View Details" button or link for each student to see their detailed information
   - Includes a link to return to the home page

4. **Student Details**: 
   - Shows all information of a selected student
   - Contains buttons or links to return to the student list or home page

5. **Search Results**: 
   - Displays the list of students found based on search criteria
   - Provides a button or link to view the details of a student
   - If no results are found, displays a message indicating "No results found"
   - Includes a link to return to the home page

### Screenshots:

![Screenshot1](screenshots/localhost_8080.png)
![Screenshot2](screenshots/localhost_8080_students-1.png)
![Screenshot3](screenshots/localhost_8080_detail_7f3a9ca9-fa6d-4eb7-a1b4-7b2ec8f70c99%20(1).png)
![Screenshot4](screenshots/localhost_8080_look_namestudent=jones%20(1).png)
![Screenshot5](screenshots/localhost_8080_look_namestudent=so.png)
![Screenshot6](screenshots/localhost_8080_add%20(1).png)
![Screenshot7](screenshots/localhost_8080_edit_672ff0b3-2a1d-4635-808e-a448e0220920.png)


