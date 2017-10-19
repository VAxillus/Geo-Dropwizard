package com.server;

import com.server.resources.CommercialResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import com.server.backend.DatabaseBackend;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Main entry point to the Geo API server.
 */
public final class GeoApplication extends Application<GeoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GeoApplication().run(args);
    }


    @Override
    public void run(final GeoConfiguration configuration, final Environment environment) {
        /*
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter("allowedMethods", "OPTIONS,GET, POST");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        */

        DatabaseBackend databaseBackend = configuration.getDatabaseBackend(environment);
        environment.jersey().register(new CommercialResource(databaseBackend));






    }


}
