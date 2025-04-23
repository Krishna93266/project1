# Use the official Tomcat image
FROM tomcat:9.0-jdk11-openjdk-slim

# Copy your WAR file to the Tomcat webapps directory
COPY target/Hospital_management_System-2.war /usr/local/tomcat/webapps/app.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
