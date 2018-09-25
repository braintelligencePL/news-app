package task

import pl.braintelligence.requirement.task.base.BaseIntegrationSpec
import pl.braintelligence.requirement.task.base.OperatingOnEndpoint

class ProjectAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnEndpoint {

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
