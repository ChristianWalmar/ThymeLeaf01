package com.example.useofstaticweb;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

  public void createUser(String userName, String password){
    User user = new User(userName, password);
    String str = "INSERT INTO `users`.`user` (`username`, `password`) VALUES (?, ?)";
    PreparedStatement preparedStatement;
    Connection connection = DBManager.getConnection();
    try{
      preparedStatement = connection.prepareStatement(str);
      preparedStatement.setString(1,userName);
      preparedStatement.setString(2,password);
      preparedStatement.execute();
    } catch (SQLException e){
      e.printStackTrace();
    }
  }

  public boolean checkLogin(String userName, String password){

    String str1 = "SELECT * FROM user where username = ? and password = ?;";
    PreparedStatement preparedStatement;
    Connection connection = DBManager.getConnection();
    try{
      preparedStatement = connection.prepareStatement(str1);
      preparedStatement.setString(1,userName);
      preparedStatement.setString(2,password);
      ResultSet resultSet = preparedStatement.executeQuery();
      boolean userExists = resultSet.next();

      if(userExists == true){
        return true;
      }
      else return false;

    } catch (SQLException e){
      e.printStackTrace();
    }
    return false;
  }
}

