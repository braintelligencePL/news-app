package pl.braintelligence.requirement.task.news.base

import com.github.tomakehurst.wiremock.stubbing.StubMapping
import com.google.common.base.Charsets
import com.google.common.io.Resources
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse
import static com.github.tomakehurst.wiremock.client.WireMock.get
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching

class NewsEndpointStubs {

    private static final String URL = "/news/pl/technology"

    static StubMapping stubNewsApiResponse() {
        return stubFor(get(urlMatching(URL)).willReturn(aResponse()
                .withStatus(HttpStatus.OK.value())
                .withHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .withBody(getFileContent("stubs/NewsResponse_NewsDto.json"))))
    }

    static String getFileContent(String filename) throws IOException {
        return Resources.toString(Resources.getResource(filename), Charsets.UTF_8)
    }
}
