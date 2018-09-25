package pl.braintelligence.requirement.task.news

import pl.braintelligence.requirement.task.base.BaseIntegrationSpec
import pl.braintelligence.requirement.task.news.base.OperatingOnEndpoint

class NewsAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnEndpoint {

    def "Project"() {
        given:
        def a = 1
        def b = 2

        when:
        a = 2

        then:
        a == b
    }
}
