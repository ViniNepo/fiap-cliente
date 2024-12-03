FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo JAR do diretório target para a imagem
COPY . .

# Comando para rodar a aplicação
CMD ["java", "-jar", "/app/my-app.jar"]
