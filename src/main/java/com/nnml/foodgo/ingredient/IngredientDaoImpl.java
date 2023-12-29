package com.nnml.foodgo.ingredient;

import com.nnml.foodgo.base.RowMapper;
import com.nnml.foodgo.database.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class IngredientDaoImpl implements IngredientDao {
    private final String FIND_ALL_SQL = "SELECT * FROM ingredient";
    RowMapper<Ingredient> rowMapper;

    public IngredientDaoImpl(RowMapper rowMapper) {
        this.rowMapper = rowMapper;
    }

    @Override
    public List<Ingredient> findAll() {
        List<Ingredient> entities = new LinkedList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseManager.getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL_SQL);
            resultSet = preparedStatement.executeQuery();
            entities.add(rowMapper.map(resultSet));
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Attempt to connect to database failed!");
            return  null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Attempt to connect to database failed");
                return null;
            }
        }
    }

    @Override
    public void save(Ingredient o) {

    }
}
