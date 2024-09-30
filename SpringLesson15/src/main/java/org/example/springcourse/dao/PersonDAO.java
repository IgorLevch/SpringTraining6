package org.example.springcourse.dao;

import org.example.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int NUMBER;


    private static final String URL = "jdbc:mysql://localhost/mystore";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "6677";

    private static Connection connection;

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
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
        String SQL = "SELECT * FROM mystore";
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

    public Person show(int id) throws SQLException {
        Person person = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Person WHERE id=?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;

    }
        public void save(Person person)  {

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Person VALUES(1, ?, ?, ?)");

            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate(); // не возвращает никакие данные, но изменяет их в БД -- эта команда - непосредственно выполнение сформированнго выше запроса к БД
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }

    public void update(int id,  Person person) throws SQLException {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");

            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void delete(int id) throws SQLException {

    PreparedStatement preparedStatement =
            null;

    try{
          preparedStatement =   connection.prepareStatement("DELETE FROM Person WHERE id = ?");

        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

        } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

}
