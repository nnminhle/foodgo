package com.nnml.foodgo.ingredient;

import com.nnml.foodgo.base.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientMapper implements RowMapper<Ingredient> {
    @Override
    public Ingredient map(ResultSet resultSet) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(resultSet.getLong("id"));
        ingredient.setName(resultSet.getString("name"));
        ingredient.setDescription(resultSet.getString("description"));

        Stock stock = new Stock();
        if (resultSet.getString("stock_id") != null) {
            stock.setId(resultSet.getLong("stock_id"));
            stock.setAvailableQuantity(resultSet.getDouble("available_quantity"));
            stock.setMaximumQuantity(resultSet.getDouble("maximum_quantity"));
            stock.setMinimumQuantity(resultSet.getDouble("minimum_quantity"));
        }
        ingredient.setStock(stock);
        return ingredient;
    }

}
