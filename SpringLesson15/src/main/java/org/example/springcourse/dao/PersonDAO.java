package org.example.springcourse.dao;

import org.example.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int NUMBER;

    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++NUMBER,"John",29,"LLoo"));
        people.add(new Person(++NUMBER,"Joe",35,"hhgg"));
        people.add(new Person(++NUMBER,"Kolya",77,"ppee"));



    }


    public List<Person> index (){
        return  people;
    }

    public Person show(int id){

        return people.stream().filter(u->u.getId()==id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++NUMBER);
        people.add(person);
    }

    public void update(int id,  Person person){

        Person personToBEUpdated = show(id);

        personToBEUpdated.setName(person.getName());
        personToBEUpdated.setAge(person.getAge());
        personToBEUpdated.setEmail(person.getEmail());

    }

    public void delete(int id){

        people.removeIf(n->n.getId()==id);
    }


}
