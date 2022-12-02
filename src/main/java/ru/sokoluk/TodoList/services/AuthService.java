package ru.sokoluk.TodoList.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sokoluk.TodoList.entity.Person;
import ru.sokoluk.TodoList.repository.PersonRepository;

@Service
@Transactional(readOnly = true)
public class AuthService {

    private final PersonRepository personRepository;

    @Autowired
    public AuthService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPerson(Person searchPerson) {
        return personRepository.findByEmailAndPassword(searchPerson.getEmail(), searchPerson.getPassword());
    }


    public boolean isValidPerson(Person checkedPerson) {
        return personRepository.findByEmailAndPassword(checkedPerson.getEmail(), checkedPerson.getPassword()) != null;
    }

    @Transactional
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
}
