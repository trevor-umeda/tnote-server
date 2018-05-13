init: build

build:
	./mvnw package -Pprod -DskipTests

deploy:
	heroku deploy:jar --jar target/*.war
