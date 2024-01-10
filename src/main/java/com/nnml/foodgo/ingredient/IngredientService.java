package com.nnml.foodgo.ingredient;

import java.util.List;

public class IngredientService {
    private final IngredientDao dao;

    public IngredientService(IngredientDao dao) {
        this.dao = dao;
    }


    public List<Ingredient> getAll() {
        return dao.getAll();
    }
}
