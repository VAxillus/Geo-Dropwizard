package com.server.backend.mapper;
import com.server.backend.Commercial;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommercialMapper implements ResultSetMapper<Commercial>{
    public Commercial map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
    {
        return new Commercial(resultSet.getInt("CommercialID"), resultSet.getString("company"),
               resultSet.getDouble("credit"), resultSet.getDate("startDate"));
    }
}
