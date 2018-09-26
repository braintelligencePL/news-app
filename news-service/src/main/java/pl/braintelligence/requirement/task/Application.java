package pl.braintelligence.requirement.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import pl.braintelligence.requirement.task.infrastructure.NewsClient;

@SpringBootApplication
@Configuration
public class Application implements CommandLineRunner {

    private final NewsClient newsClient;

    public Application(NewsClient newsClient) {
        this.newsClient = newsClient;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run();
    }

    public void run(String... args) {
    }
}
