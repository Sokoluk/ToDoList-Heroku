package ru.sokoluk.TodoList.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "task")
    private String task;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id",referencedColumnName = "id")
    @JsonBackReference
//    @NotEmpty(message = "Данное поле не может быть пустым")
    private Title title;

    @Column(name = "active")
    private boolean active;

    public Task() {
    }

    public Task(String taskName, Title title){
        this.task = taskName;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", title=" + title +
                ", active=" + active +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Task task1 = (Task) o;
//        return id == task1.id && active == task1.active && Objects.equals(task, task1.task) && Objects.equals(title, task1.title);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, task, title, active);
//    }
}
