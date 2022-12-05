package ru.sokoluk.TodoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sokoluk.TodoList.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByEmailAndPassword(String email, String password);

    Person findByActiveIsTrue();
}
