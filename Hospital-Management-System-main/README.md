🏥 Hospital Management System - Java Project

A Hospital Management System built using Java J2EE technologies, including Servlets, JSP, JDBC, and MySQL for efficient database management. This system is designed to streamline hospital operations, managing patients, doctors, appointments, and user authentication for admins, doctors, and users.

📚 Table of Contents

💻 Technologies Used

🗂️ Project Structure

🖥️ Backend Code

📱 Frontend Code

🚀 How to Run the Project

⚙️ Setup Instructions

🏁 Conclusion

💻 Technologies Used

🎨 Frontend:

✅ HTML, CSS, JavaScript – For structuring and styling web pages

✅ Bootstrap – Ensuring a responsive and mobile-friendly design

✅ JSP (JavaServer Pages) – Dynamic content rendering

✅ FontAwesome – Enhancing UI with icons

⚙️ Backend:

✅ Servlets – Handling HTTP requests and responses

✅ JDBC (Java Database Connectivity) – Connecting and managing MySQL database interactions

🖥️ Server:

✅ Apache Tomcat – Deploying and running the application

📊 Database:

✅ MySQL – Storing and managing hospital-related data

🛠️ Development Tools:

✅ Eclipse IDE – For writing and managing Java code

✅ MySQL Workbench – For designing and managing the database

🗂️ Project Structure

📂 Backend Code

The backend is well-structured into multiple packages for modularity and efficiency:

com.admin.servlet – Handles admin functionalities (managing doctors, patients, and appointments).

com.dao – Contains Data Access Objects (DAO) for database interactions.

com.db – Manages database connections.

com.doctor.servlet – Handles doctor-related functionalities (appointments, profile management).

com.entity – Defines entity classes such as Doctor, Patient, Appointment.

com.user.servlet – Manages user functionalities (appointment booking, login, and profile handling).

🎨 Frontend Code

The frontend is designed for an intuitive user experience using JSP, HTML, CSS, and JavaScript.

Admin Pages: Admin login, doctor & patient management, appointment viewing.

Doctor Pages: Doctor login, profile editing, appointment management.

User Pages: User login, appointment booking, profile editing.

Common Components: Navbar, footer, and shared CSS files for a uniform design.

🖥️ Backend Code: Main Packages

🔹 Admin Servlet – Manages admin authentication, doctor & patient data, and appointment records.

🔹 Doctor Servlet – Handles doctor authentication, profile updates, and appointment views.

🔹 User Servlet – Enables user authentication, appointment scheduling, and profile management.

🔹 DAO – Connects the application to MySQL and performs database operations.

📱 Frontend Code: Key Pages

admin_login.jsp – Admin login page.

doctor_login.jsp – Doctor login page.

user_login.jsp – User login page.

navbar.jsp – Navigation bar for all pages.

index.jsp – Home page of the system.

view_appointment.jsp – Appointment viewing page for users and doctors.

🚀 How to Run the Project

🔧 Prerequisites

Make sure you have the following installed:

Apache Tomcat – To host and run the application.

MySQL Database – For storing system data.

JDK (Java Development Kit) – For compiling and running Java code.

⚡ Steps to Run

Clone the Repository:

git clone https://github.com/yourusername/Hospital-Management-System.git

Set Up the Database:

Create a MySQL database named hospital_management_system.

Execute the provided SQL script to create required tables.

CREATE DATABASE hospital_management_system;
-- Import the SQL file for tables structure

Configure Database Connection:

Open com.db.DbConnection.java and update MySQL credentials (username, password, and database name).

Ensure mysql-connector-java.jar is included in your Tomcat lib folder.

Deploy to Apache Tomcat:

Build the project in Eclipse.

Deploy the WAR file by copying it to the webapps folder in Tomcat.

Access the Application:

Open your browser and go to:

http://localhost:8080/Hospital_Management_System-2

Log in as Admin, Doctor, or User and start managing the hospital system.

⚙️ Setup Instructions

📌 Eclipse Setup:

Import the project into Eclipse IDE.

Set up Apache Tomcat as the server runtime.

Build and deploy the project.

📌 MySQL Database Setup:

Create a new database hospital_management_system.

Run the provided SQL scripts to create required tables (users, doctors, appointments, etc.).

📌 Database Connection:

Modify com.db.DbConnection.java with your MySQL username, password, and database details.

Add the mysql-connector-java.jar to the Tomcat lib directory.

🏁 Conclusion

This Hospital Management System provides a structured solution for hospitals to manage their operations efficiently. With features like user authentication, doctor & patient management, and appointment scheduling, it serves as an excellent learning experience for Java J2EE, Servlets, JSP, and MySQL enthusiasts.

🚀 Enhance it further by adding new features like:
🔹 Email notifications for appointments🔹 Payment gateway for online consultations🔹 Role-based access for different users🔹 Graphical analytics for hospital reports

📢 Contributions are welcome! Feel free to fork, enhance, and submit pull requests.

💻 Developed with ❤️ by Anant Agarwal

