package pl.braintelligence.requirement.task.base

import org.junit.Rule
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.ActiveProfiles
import pl.braintelligence.requirement.task.Application
import pl.braintelligence.requirement.task.infrastructure.config.Profiles
import spock.lang.Specification

@SpringBootTest(
        classes = [Application],
//        properties = "application.environment=local",
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles([Profiles.LOCAL])
abstract class BaseIntegrationSpec extends Specification {

    @Autowired
    MongoTemplate mongo

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(12346)

    void setupSpec() { wiremockFix() }

    void setup() { clearMongoDb() }

    private static void wiremockFix() {
        System.setProperty('http.keepAlive', 'false')
        System.setProperty('http.maxConnections', '1')
    }

    private void clearMongoDb() {
        for (def collection : mongo.collectionNames) {
            mongo.dropCollection(collection)
        }
    }
}
