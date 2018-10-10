package pl.braintelligence.requirement.task.news

import pl.braintelligence.requirement.task.base.BaseIntegrationSpec
import pl.braintelligence.requirement.task.news.base.OperatingOnNewsEndpoint

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.requirement.task.news.base.NewsEndpointStubs.*

class NewsAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnNewsEndpoint {

    def "Should return stubbed top-headlines articles from NewsAPI"() {
        given: "prepare stub for news"
        stubNewsApiResponse()

        when: "user asks for top-headlines"
        def response = getTopHeadlines()

        then: "verify that system response is correct"
        response.statusCode.is2xxSuccessful()
        response.body.articles.size == 20
        response.body.country == "pl"
        response.body.category == "technology"
        response.body.articles[12].date == "2018/10/10"
        response.body.articles[2].author == null
        response.body.articles[1].sourceName == "Test"
        response.body.articles[3].title == "Lepiej późno niż wcale."
        response.body.articles[1].articleUrl == "https://www.test.html"
        response.body.articles[3].description == "albo, albo"
        response.body.articles[2].imageUrl == "https://test.test"
    }

}
