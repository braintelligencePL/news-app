package pl.braintelligence.requirement.task.application.dto;

import java.util.ArrayList;
import java.util.List;

public class NewsSource {

    private String status;
    List<Source> sources;

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