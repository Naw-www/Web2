# Sử dụng Tomcat 11 + JDK 
FROM tomcat:11.0.0-jdk11

# Xóa ứng dụng mặc định của Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file WAR của bạn vào Tomcat và đặt tên ROOT.war
COPY target/Web-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Tomcat mặc định chạy cổng 8080
EXPOSE 8080

# Chạy Tomcat
CMD ["catalina.sh", "run"]
