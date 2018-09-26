package pl.braintelligence.requirement.task.application.dto;

import java.util.List;

import pl.braintelligence.requirement.task.domain.values.Source;

public class NewsSource {

    private String status;
    private List<Source> sources;

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

