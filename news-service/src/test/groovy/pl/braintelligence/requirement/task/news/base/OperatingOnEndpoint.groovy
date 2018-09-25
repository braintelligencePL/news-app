package pl.braintelligence.requirement.task.news.base

import org.springframework.http.ResponseEntity
import pl.braintelligence.requirement.task.base.BaseHttpMethodsSpec

trait OperatingOnEndpoint implements BaseHttpMethodsSpec {

    ResponseEntity createProjectDraft(Object requestBody) {
        return post('/projects/drafts', requestBody)
    }

}