package com.server;

import static com.google.common.base.Preconditions.checkNotNull;

import com.server.backend.DatabaseBackend;
import com.server.backend.DatabaseConfiguration;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;


/**
 * Server configuration for the Geo API server.
 */
public final class GeoConfiguration extends Configuration {
    private final DatabaseConfiguration databaseConfiguration;

    @JsonCreator
    public GeoConfiguration(
            @JsonProperty("database") final DatabaseConfiguration database) {
        checkNotNull(database);

        this.databaseConfiguration = database;
    }

    public DatabaseConfiguration getDatabaseConfiguration() { return databaseConfiguration; }

    public DatabaseBackend getDatabaseBackend(Environment environment) {
        return databaseConfiguration.createDBI(environment, "jdbi-mariadb-backend").onDemand(DatabaseBackend.class);
    }


}
