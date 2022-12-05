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

    @Transactional
    public boolean isValidPerson(Person checkedPerson) {
        Person person = personRepository.findByEmailAndPassword(checkedPerson.getEmail(), checkedPerson.getPassword());
        if (person != null) {
            person.setActive(true);
            return true;
        }
        return false;
    }

    @Transactional
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public Person getRememberedPerson() {
        Person person = personRepository.findByActiveIsTrue();
        if (person == null) {
            Person newPerson = new Person();
            newPerson.setActive(false);
            return newPerson;
        }
        else
        return person;
    }

    @Transactional
    public Person logout(Person person) {
        Person upPerson = personRepository.getById(person.getId());
        upPerson.setActive(false);
        return personRepository.save(upPerson);
    }
}
