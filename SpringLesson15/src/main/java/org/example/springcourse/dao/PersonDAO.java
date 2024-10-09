package org.example.springcourse.dao;

import org.example.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

   private final JdbcTemplate jdbcTemplate;

   @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index () throws SQLException {
           return  jdbcTemplate.query("SELECT * FROM users", /*new PersonMapper()*/ new BeanPropertyRowMapper<>(Person.class));

    }

    public Person show(int id) throws SQLException {

       return jdbcTemplate.query("SELECT * FROM users WHERE id=?",  new Object[]{id}, /*new PersonMapper()*/
                       new BeanPropertyRowMapper<>(Person.class))
               .stream().findAny().orElse(null);


    }
        public void save(Person person)  {

        jdbcTemplate.update("INSERT INTO users VALUES(1, ?, ?, ?)",
                person.getAge(),person.getName(),person.getEmail());


    }

    public void update(int id,  Person person) throws SQLException {

       jdbcTemplate.update("UPDATE users SET name=?,email=?,age=? WHERE id =?", person.getAge(),
               person.getName(),person.getEmail(), id);

    }

    public void delete(int id) throws SQLException {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

}
