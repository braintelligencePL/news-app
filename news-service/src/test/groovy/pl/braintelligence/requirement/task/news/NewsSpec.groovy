package pl.braintelligence.requirement.task.news

import pl.braintelligence.requirement.task.base.BaseIntegrationSpec
import pl.braintelligence.requirement.task.news.base.OperatingOnNewsEndpoint

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.braintelligence.requirement.task.news.base.NewsEndpointStubs.*

class NewsSpec extends BaseIntegrationSpec implements OperatingOnNewsEndpoint {

    def "Should return error when category doesn't exist"() {
        given:
        def nonExistentCategory = "tech 123"
        def country = "pl"

        when:
        def response = getTopHeadlines(nonExistentCategory, country)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == 'NONEXISTENT_CATEGORY'
    }

    def "Should return error when country doesn't exist"() {
        given:
        def category = "technology"
        def nonExistentCountry = "1234"

        when:
        def response = getTopHeadlines(category, nonExistentCountry)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == 'NONEXISTENT_COUNTRY'
    }

    def "Should get stubbed top-headlines from NewsAPI"() {
        given: "prepare stub for news"
        stubNewsApiResponse()

        when: "user asks for top-headlines"
        def response = getTopHeadlines()

        then: "verify that system response is correct"
        response.statusCode.is2xxSuccessful()
        response.body.country == "pl"
        response.body.category == "technology"
        response.body.articles[12].date == "2018/09/26"
        response.body.articles[2].author == "Dawid Długosz"
        response.body.articles[1].sourceName == "Rmfmaxxx.pl"
        response.body.articles[3].title == "Jeden powód mniej, by używać launchera. Google wprowadza personalizację widżetu wyszukiwania"
        response.body.articles[1].articleUrl == "https://www.rmfmaxxx.pl/news/QRecorder-Sprawdz-dlaczego-ta-aplikacja-jest-niebezpieczna,42626.html"
        response.body.articles[11].description == "Lepiej późno niż wcale. Microsoft udostępni deweloperom możliwość zaimplementowania obsługi tych pecetowych narzędzi w swoich grach."
        response.body.articles[2].imageUrl == "https://ocdn.eu/pulscms-transforms/1/NRCktkqTURBXy9lNDBjZmFkYWJiMzA3MzhmNTU2MmRiM2ZhMDcyYzY1Ny5qcGVnkpUDGADNAm7NAV6TBc0B4M0BaA"
    }

}
