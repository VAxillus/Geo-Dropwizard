package com.server;

import io.dropwizard.Application;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.server.backend.DatabaseBackend;

/**
 * Main entry point to the Geo API server.
 */
public final class GeoApplication extends Application<GeoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GeoApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<GeoConfiguration> bootstrap) {
      
    }

    @Override
    public void run(final GeoConfiguration configuration, final Environment environment) {
        //DatabaseBackend databaseBackend = configuration.getDatabaseBackend(environment);
    }
}
