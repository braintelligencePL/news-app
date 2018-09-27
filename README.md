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
  
`GET: /news/{country}/{category} - shows top-headlines

## Working with frontend

Frontend can be found here: `http://localhost:8081/`

Frontend generated with [vue-cli](https://cli.vuejs.org/guide/creating-a-project.html#vue-create)



