# Usa a imagem base do Java 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado (você deve garantir que esse caminho esteja certo)
COPY target/*.jar app.jar

# Expõe a porta do Spring Boot (ajuste conforme necessário)
EXPOSE 8081

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
