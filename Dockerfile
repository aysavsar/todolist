FROM openjdk:17-jdk-slim

# Uygulama jar dosyasını kopyalayın
COPY target/todolist-0.0.1-SNAPSHOT.jar app.jar

# Jar dosyasını çalıştırın
ENTRYPOINT ["java", "-jar", "/app.jar"]
