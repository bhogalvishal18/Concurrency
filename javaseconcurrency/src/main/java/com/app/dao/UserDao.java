/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import com.app.beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vishal
 */
public class UserDao {
    public int saveUser(User user){
         int rows=0;
        try {
           
            Connection connection=DBConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement("insert into user values(?,?,?)");
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmailAddress());
            rows=statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      return  rows;
    }
}
