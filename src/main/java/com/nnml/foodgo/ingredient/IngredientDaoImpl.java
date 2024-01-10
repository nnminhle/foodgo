package com.nnml.foodgo.ingredient;

import com.nnml.foodgo.base.impl.CoreDaoImpl;

import java.util.List;

public class IngredientDaoImpl extends CoreDaoImpl<Ingredient> implements IngredientDao {

    @Override
    public List<Ingredient> getAll() {
        String sql = "SELECT * FROM ingredients";
        return query(sql, new IngredientMapper());
    }
}
