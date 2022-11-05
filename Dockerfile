FROM openjdk:17
WORKDIR /app
COPY . .
LABEL maintainer = "hordiienko"
ADD target/restaurantMenu.jar restaurant-menu.jar
ENTRYPOINT ["java", "-jar", "restaurant-menu.jar"]