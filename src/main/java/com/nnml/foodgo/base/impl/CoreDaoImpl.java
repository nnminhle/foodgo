package com.nnml.foodgo.base.impl;

import com.nnml.foodgo.base.CoreDao;
import com.nnml.foodgo.base.RowMapper;
import com.nnml.foodgo.database.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CoreDaoImpl<T> implements CoreDao<T> {
    @Override
    public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {

        try (Connection connection = DatabaseManager.getConnection()) {
            return doPrepareStatement(connection, rowMapper, sql, parameters);
        } catch (SQLException e) {
            System.err.println("Attempt connect to database failed: " + e);
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("Error when try to load driver: " + e);
            return null;
        }
    }

    List<T> doPrepareStatement(Connection connection, RowMapper<T> rowMapper, String sql, Object... parameters) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                    preparedStatement.setLong(index, (Long) parameter);
                } else if (parameter instanceof Integer) {
                    preparedStatement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Double) {
                    preparedStatement.setDouble(index, (Double) parameter);
                } else if (parameter instanceof String) {
                    preparedStatement.setString(index, (String) parameter);
                }
            }
            return doResultSet(preparedStatement, rowMapper);
        } catch (SQLException e) {
            System.err.println("Error executing statement: " + e);
            return null;
        }
    }

    List<T> doResultSet(PreparedStatement statement, RowMapper<T> rowMapper) {
        List<T> results = new LinkedList<>();
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                results.add(rowMapper.map(resultSet));
            }
            return results;
        } catch (SQLException e) {
            System.err.println("Query error: " + e);
            return null;
        }
    }

}
