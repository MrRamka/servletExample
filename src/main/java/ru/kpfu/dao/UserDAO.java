package ru.kpfu.dao;

import ru.kpfu.entities.Role;
import ru.kpfu.servlets.User;
import ru.kpfu.util.ConnectionToDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection = ConnectionToDatabase.getConnection();

    public int addUser(String name, String email, String md5HexPassword, List<String> role) throws SQLException {
        String sqlQuery = "INSERT INTO users (name, email, password, role, salt) values( ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, md5HexPassword);
        preparedStatement.executeUpdate();

        RoleDAO roleDAO = new RoleDAO();
        UserRole userRole = new UserRole();
        List<Role> roles = roleDAO.getRoles();
        List<String> rolesName = new ArrayList<>();
        for (Role r : roles) {
            rolesName.add(r.getName());
        }
        for (int i = 0; i < role.size(); i++) {
            if (!rolesName.contains(role.get(i))){
                roleDAO.addRole(role.get(i));
                userRole.userRole(getUserByEmail(email).getId(), roleDAO.getRoleByName(role.get(i)).getId());
            }else {
                userRole.userRole(getUserByEmail(email).getId(), roleDAO.getRoleByName(role.get(i)).getId());
            }

        }
        return preparedStatement.executeUpdate();
    }
    public User getUserByEmail(String userEmail) throws SQLException {
        String sqlQuery = "SELECT * FROM users WHERE email = ?";
        PreparedStatement getUserByIdStatement = connection.prepareStatement(sqlQuery);
        getUserByIdStatement.setString(1, userEmail);
        ResultSet resultSet = getUserByIdStatement.executeQuery();
        return getUserByResultSet(resultSet);
    }
    private static User getUserByResultSet(ResultSet resultSet) throws SQLException {
        resultSet.next();
        return new User(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("password")
        );
    }
}
