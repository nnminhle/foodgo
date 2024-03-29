package com.nnml.foodgo.base;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T, ID> {
    List<T> findAll() throws SQLException;

    void save(T o);

}
