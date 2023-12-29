package com.nnml.foodgo.base.impl;

import com.nnml.foodgo.base.CoreDao;
import com.nnml.foodgo.base.RowMapper;

import java.util.List;

public class BaseDaoImpl<T> implements CoreDao {
    @Override
    public List query(String sql, RowMapper rowMapper, Object[] parameters) {
        return null;
    }
}
