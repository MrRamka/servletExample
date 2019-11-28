package ru.kpfu.dao;

import ru.kpfu.entities.Role;
import ru.kpfu.util.ConnectionToDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRole {
    private Connection connection = ConnectionToDatabase.getConnection();

    public int userRole(int userId, int roleId) throws SQLException {
        String q = "insert into user_role (user_id, role_id) values (?, ?)";
        PreparedStatement p = connection.prepareStatement(q);
        p.setInt(1, userId);
        p.setInt(2, roleId);
        return p.executeUpdate();
    }
}
