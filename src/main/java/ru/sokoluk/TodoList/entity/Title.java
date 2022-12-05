package ru.sokoluk.TodoList.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Title")
public class Title {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    @NotEmpty(message = "Данное поле не может быть пустым")
    @Size(max = 16, min = 1, message = "Недопустимая длина Title")
    private String title;

    @OneToMany(mappedBy = "title")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
//    @JsonIgnore
    private List<Task> tasks;

//    @ManyToOne //(fetch = FetchType.LAZY)
//    @JoinColumn(name = "person_id",referencedColumnName = "id")
//    @JsonBackReference
//    private Person person;

    public Title() {
    }

    public Title(String title) {
        this.title = title;
    }

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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
