package org.example.springcourse.dao;

import org.example.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int NUMBER;


    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);  // это подключение к БД
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public List<Person> index () throws SQLException {
       List<Person> people = new ArrayList<>(); // это куда будем класть людей, которых достанем из БД
        Statement statement = connection.createStatement();  //объект, содержащий в себе СКЛь запрос к БД
        String SQL = "SELECT * FROM Person";
        ResultSet resultSet = statement.executeQuery(SQL);  //   ResultSet  -  это объект , который инкапсулирует результат выполнения запроса к БД

        // далее проходимся по каждой из строк и переводим в джава -объект:

        while (resultSet.next()){

            Person person = new Person();

            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));
            person.setAge(resultSet.getInt("age"));

            people.add(person);


        }

        return people;

    }

    public Person show(int id){

       // return people.stream().filter(u->u.getId()==id).findAny().orElse(null);
        return null;
    }

    public void save(Person person)  {
//        person.setId(++NUMBER);
//        people.add(person);
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
                    "'," + person.getAge() + ",'" + person.getEmail() + "')";

            statement.executeUpdate(SQL); // не возвращает никакие данные, но изменяет их в БД
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }

    public void update(int id,  Person person){

//        Person personToBEUpdated = show(id);
//
//        personToBEUpdated.setName(person.getName());
//        personToBEUpdated.setAge(person.getAge());
//        personToBEUpdated.setEmail(person.getEmail());

    }

    public void delete(int id){

     //   people.removeIf(n->n.getId()==id);
    }


}
