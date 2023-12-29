package com.nnml.foodgo.base;

import java.util.List;

public interface CoreDao<T> {
    List<T> query(String sql, RowMapper<T> rowMapper, Object[] parameters);
}
