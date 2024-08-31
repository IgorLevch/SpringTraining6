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
        people.add(new Person(++NUMBER,"John"));
        people.add(new Person(++NUMBER,"Joe"));
        people.add(new Person(++NUMBER,"Kolya"));



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



}
