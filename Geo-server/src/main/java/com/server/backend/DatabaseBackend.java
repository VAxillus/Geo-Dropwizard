package com.server.backend;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import com.server.backend.Commercial;
import com.server.backend.mapper.CommercialMapper;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.sql.Date;
import java.util.List;

@RegisterMapper(CommercialMapper.class)
public abstract class DatabaseBackend {


    @SqlQuery("SELECT * FROM Commercial")
    public abstract List<Commercial> getAll();

    @SqlUpdate("INSERT INTO Commercial (company, credit, startDate) values (:company, :credit, :startDate)")
    public abstract void submitCommercial(@Bind("company") String company, @Bind("credit") double credit,
                                          @Bind("startDate") Date startDate);

}
