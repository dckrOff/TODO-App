package com.dckroff.todoapp.model;

public class Todo {

    private int id;
    private int priority;
    private String title;
    private String imageUrl;
    private String completedDate;
    private boolean isCompleted;

    public Todo(int id, int priority, String title, String imageUrl, String completedDate, boolean isCompleted) {
        this.id = id;
        this.priority = priority;
        this.title = title;
        this.imageUrl = imageUrl;
        this.completedDate = completedDate;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
