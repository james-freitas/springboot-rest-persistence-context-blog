package com.example.app.dto;

public class PostDTO {

    private Integer id;
    private String topicName;
    private String title;

    public PostDTO(Integer id, String title, String topicName) {
        this.id = id;
        this.topicName = topicName;
        this.title = title;
    }

    public PostDTO() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
