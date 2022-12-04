package ru.sokoluk.TodoList.dto;

import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Column;

import javax.validation.constraints.NotEmpty;

public class TitleDTO {

    private int id;

    @NotEmpty(message = "Данное поле не может быть пустым")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
