# News Application

Simple application that works as mediator of external API calls [NewsAPI](https://newsapi.org/docs/endpoints/top-headlines)

## Pre-setup for IDE (IntellJ Idea)
- [x] `enable annotation processing` in your IDE

<BR>

## Working with backend

`./gradlew bootRun` - to run application. <BR>
`./gradlew test` - to run tests. <BR>
`./gradlew clean build test` - all in one command. <BR>

Documentation can be found here `http://localhost:8080//swagger-ui.html#/`

<BR>
  
`GET: /news/{country}/{category}` - shows top-headlines

## Working with frontend

Frontend can be found here: `http://localhost:8081/`

Frontend generated with [vue-cli](https://cli.vuejs.org/guide/creating-a-project.html#vue-create)




Run application with Docker:



### Building news-service (backend)
1. Run from command line or IDE (Gradle):
`gradle clean build docker`

2. Command `gradle docker` generated `.jar` file that can be found here `build/docker/news-service-0.1.0.jar`.

3. Now build docker image `docker build -f Dockerfile -t docker-news-service.jar .`
```
`-f Dockerfile` - your docker script on which you'll build image.
`-t docker-news-service` - name of your image.
` . ` - dot at the end simply means build from this file.
```

Run `docker images` or `docker image ls` to show all your images.

How to run your docker image? 

`docker run -p 8085:8080 docker-news-service`

`-p 8085 ` - is how you expose your container. 
' :8080 ' is port on which your application operates.

after that you can check our application. 
Run `localhost:8085/news/pl/technology` to see results.

# Having trouble? Try these.

- `gradle wrapper` - download gradle wrapper
- `docker run -it openjdk java -version` 




