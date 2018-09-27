package pl.braintelligence.requirement.task.news.base

import org.springframework.http.ResponseEntity
import pl.braintelligence.requirement.task.base.BaseHttpMethodsSpec

trait OperatingOnNewsEndpoint implements BaseHttpMethodsSpec {

    private final String LOCAL_URL = "http://localhost:12346/"

    String localUrl(String path) {
        return LOCAL_URL + path
    }

    ResponseEntity getTopHeadlines(String path) {
        return get(localUrl(path), Object)
    }

    ResponseEntity getTopHeadlines(String category, String country) {
        return get("/news/$country/$category", Object)
    }
}