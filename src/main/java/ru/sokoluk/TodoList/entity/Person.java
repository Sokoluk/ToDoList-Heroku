package ru.sokoluk.TodoList.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
//    @NotEmpty(message = "Данное поле не может быть пустым")
//    @Email
    private String email;

    @Column(name = "password")
//    @NotEmpty(message = "Данное поле не может быть пустым")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "role")
    private String role;


//    @OneToMany(mappedBy = "person")
//    private List<Title> titles;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
