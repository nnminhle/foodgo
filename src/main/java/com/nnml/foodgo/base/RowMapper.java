package com.nnml.foodgo.base;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

    T map(ResultSet resultSet) throws SQLException;
}
