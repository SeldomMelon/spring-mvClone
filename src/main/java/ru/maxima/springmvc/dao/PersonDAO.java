package ru.maxima.springmvc.dao;

import org.springframework.stereotype.Component;
import ru.maxima.springmvc.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private int PEOPLE_COUNT;
    private List<Person> people;

    public PersonDAO() {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Oleg",25,"Oleg@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Petya",23,"Petya@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Ivan",21,"Ivan@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Nikolay",24,"Nikolay@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id){
        return people.stream()
                .filter(p -> p.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());

    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
