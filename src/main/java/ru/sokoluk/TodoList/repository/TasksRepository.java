package ru.sokoluk.TodoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sokoluk.TodoList.entity.Task;

public interface TasksRepository extends JpaRepository<Task, Integer> {
}
