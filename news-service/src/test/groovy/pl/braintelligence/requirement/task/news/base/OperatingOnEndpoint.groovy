package pl.braintelligence.requirement.task.news.base

import org.springframework.http.ResponseEntity
import pl.braintelligence.requirement.task.base.BaseHttpMethodsSpec

trait OperatingOnEndpoint implements BaseHttpMethodsSpec {

    ResponseEntity getTopHeadlines() {
        return get("http://localhost:12346/news/pl/technology", Object)
    }

}