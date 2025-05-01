# 🥘 TasteBite Backend - [Live Demo](https://taste-bite-three.vercel.app/)

TasteBite is a recipe application that allow users to search for recipes, view categorized recipes, explore
highly recommended dishes, and access detailed instructions on how to make each recipe.

This repository contains the Spring Boot-based backend API of the TasteBite application.


# ⚙️ Install
Clone the project.
```
git clone https://github.com/SuleAktas/taste-bite-be.git
```
Install dependencies
```
./mvnw clean install
```
# 💻 Run
Create .env file with the following properties
```
DATASOURCE_URL=
DATASOURCE_USER=
DATASOURCE_PASSWORD=
```
Run the spring boot
```
export $(cat .env | xargs)
./mvnw spring-boot:run
```
