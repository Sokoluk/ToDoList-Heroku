package ru.sokoluk.TodoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sokoluk.TodoList.entity.Title;

public interface TitlesRepository extends JpaRepository<Title, Integer> {
}
