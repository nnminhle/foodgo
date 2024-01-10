package com.nnml.foodgo.ingredient;

import com.nnml.foodgo.base.BaseDao;
import com.nnml.foodgo.base.CoreDao;

import java.util.List;
import java.util.Optional;

public interface IngredientDao extends CoreDao<Ingredient> {
    List<Ingredient> getAll();

}
