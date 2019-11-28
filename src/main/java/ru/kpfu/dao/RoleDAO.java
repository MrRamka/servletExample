package ru.kpfu.dao;

import ru.kpfu.entities.Role;
import ru.kpfu.util.ConnectionToDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    private Connection connection = ConnectionToDatabase.getConnection();

    public List<Role> getRoles() throws SQLException {
        List<Role> roles = new ArrayList<>();
        String q = "select * from roles";
        PreparedStatement p = connection.prepareStatement(q);
        ResultSet resultSet = p.executeQuery();
        while (resultSet.next()){
            roles.add(new Role(resultSet.getInt("id"),
                    resultSet.getString("name")));
        }
        return roles;
    }
    public int addRole(String name) throws SQLException {
        String q = "insert into roles (`name`) values (?)";
        PreparedStatement p = connection.prepareStatement(q);
        p.setString(1, name);
        return p.executeUpdate();
    }
    public Role getRoleByName(String name) throws SQLException {
        Role role = null;
        String q = "select * from roles where `name` = ?";
        PreparedStatement p = connection.prepareStatement(q);
        p.setString(1,name);
        ResultSet resultSet = p.executeQuery();
        while (resultSet.next()){
            role = new Role(resultSet.getInt("id"),
                    resultSet.getString("name"));
        }
        return role;


    }
}
