package pl.braintelligence.requirement.task.news

import pl.braintelligence.requirement.task.base.BaseIntegrationSpec
import pl.braintelligence.requirement.task.news.base.OperatingOnEndpoint

import static pl.braintelligence.requirement.task.news.base.NewsStubs.*

class NewsAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnEndpoint {

    def "Should get stubbed top-headlines from NewsAPI"() {
        given: "prepare stub for endpoint /news/{country}/{category}"
        stubNewsApiResponse()

        when: "user asks for top-headlines news articles"
        def response = getTopHeadlines()

        then: "system response with articles"
        response.statusCode.is2xxSuccessful()
        response.body.country == "pl"
        response.body.category == "technology"
        response.body.articles[1].author == "Aquma"
    }
}
