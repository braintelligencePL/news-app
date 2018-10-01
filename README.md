# News Application

Simple application that works as mediator of external API calls [NewsAPI](https://newsapi.org/docs/endpoints/top-headlines)

![](/images/frontend.png)

### Endpoints:
`GET: /news/{country}/{category}` - shows top-headlines articles. <BR>
`GET: /news?query=programming` - you can search for articles e.g. programming.

### Pre-setup for IDE (IntellJ Idea)
- [x] `enable annotation processing` in your IDE

### Prerequisites 
- min. JDK-8, Docker, npm

<BR>

## Working with backend (non-docker)

`./gradlew bootRun` - to run application <BR>
`./gradlew test` - to run tests <BR>
`./gradlew clean build test` - all in one command <BR>

Generated documentation can be found here `http://localhost:8080/api/swagger-ui.html`

<br>

## Working with frontend (non-docker)

Frontend is generated with [vue-cli](https://cli.vuejs.org/guide/creating-a-project.html#vue-create).

`npm install` - project setup  <br>
`npm run serve` - compiles and hot-reloads for development <br>
`npm run build` - compiles and minifies for production <br>
`npm run lint` - lints and fixes files  <br>

Frontend can be found here: `http://localhost:8081/`

<br>

## Run applications with Docker:

Run both front + back: <br>
- `cd news-service && ./gradlew clean build docker` <br>
- `docker-compose build`<br>
- `docker-compose up`<br>
Frontend here: `http://localhost:8081/`<br>
Backend here: `http://localhost:8080/...`<br>
Backend documentation here: `http://localhost:8080/api/swagger-ui.html`<br>

### Additionally
#### Backend
- `cd news-service` 
- `./gradlew clean build docker`
- `docker build -f Dockerfile -t docker-news-service .`
- `docker run -p 8080:8080 docker-news-service`

#### Frontend
- `cd news-frontend`
- `docker build -t vuejs-cookbook/dockerize-vuejs-app .`
- `docker run -it -p 8080:80 --rm --name dockerize-vuejs-app-1 vuejs-cookbook/dockerize-vuejs-app`

[Commands description](https://github.com/braintelligencePL/playgrounds/tree/master/tips_tricks/docker) <br>
To show running containers run command `docker ps`. <br>
To show your local docker images run command `docker images`. <br>
