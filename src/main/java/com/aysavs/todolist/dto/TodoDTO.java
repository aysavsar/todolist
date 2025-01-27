package com.aysavs.todolist.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoDTO {

    @NotBlank(message = "Title is mandatory")
    private String title;

    private boolean completed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
