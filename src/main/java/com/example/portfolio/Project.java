package com.example.portfolio;

import java.util.List;

public class Project {
    private String title;
    private String description;
    private List<String> technologies;
    private String link;
    private String thumbnail;

    public Project() {}

    public Project(String title, String description, List<String> technologies, String link, String thumbnail) {
        this.title = title;
        this.description = description;
        this.technologies = technologies;
        this.link = link;
        this.thumbnail = thumbnail;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<String> getTechnologies() { return technologies; }
    public void setTechnologies(List<String> technologies) { this.technologies = technologies; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }
}
