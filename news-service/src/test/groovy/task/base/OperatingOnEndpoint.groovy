package task.base

import org.springframework.http.ResponseEntity

trait OperatingOnEndpoint implements BaseHttpMethodsSpec {

    ResponseEntity createProjectDraft(Object requestBody) {
        return post('/projects/drafts', requestBody)
    }

}