package pl.braintelligence.requirement.task.news

import pl.braintelligence.requirement.task.base.BaseIntegrationSpec
import pl.braintelligence.requirement.task.news.base.OperatingOnEndpoint

import static pl.braintelligence.requirement.task.news.base.NewsStubs.*

class NewsAcceptanceSpec extends BaseIntegrationSpec implements OperatingOnEndpoint {

    def "Should get stubbed top-headlines from NewsAPI"() {
        given: "prepare stub for endpoint /news/{country}/{category}"
        stubNewsApiResponse()

        when: "user asks for top-headlines"
        def response = getTopHeadlines()

        then: "system response"
        response.statusCode.is2xxSuccessful()
        response.body.country == "pl"
        response.body.category == "technology"
        response.body.articles[2].author == "Dawid Długosz"
        response.body.articles[3].title == "Jeden powód mniej, by używać launchera. Google wprowadza personalizację widżetu wyszukiwania"
        response.body.articles[11].description == "Lepiej późno niż wcale. Microsoft udostępni deweloperom możliwość zaimplementowania obsługi tych pecetowych narzędzi w swoich grach."
        response.body.articles[12].date == "2018/09/26"
        response.body.articles[1].sourceName == "Rmfmaxxx.pl"
        response.body.articles[1].articleUrl == "https://www.rmfmaxxx.pl/news/QRecorder-Sprawdz-dlaczego-ta-aplikacja-jest-niebezpieczna,42626.html"
        response.body.articles[2].imageUrl == "https://ocdn.eu/pulscms-transforms/1/NRCktkqTURBXy9lNDBjZmFkYWJiMzA3MzhmNTU2MmRiM2ZhMDcyYzY1Ny5qcGVnkpUDGADNAm7NAV6TBc0B4M0BaA"

    }
}
