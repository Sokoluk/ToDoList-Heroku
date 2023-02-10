package ru.sokoluk.TodoList.dto;

import javax.persistence.Column;

public class AuthDTO {
    @Column(name = "email")
//    @NotEmpty(message = "Данное поле не может быть пустым")
//    @Email
    private String email;

    @Column(name = "password")
//    @NotEmpty(message = "Данное поле не может быть пустым")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
