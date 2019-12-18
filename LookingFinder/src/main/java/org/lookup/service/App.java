package org.lookup.service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.lookup.service.constants.Provider;
import org.lookup.service.factory.LookupServiceFactory;
import org.lookup.service.service_interface.ILookupService;

public class App {
    public static void main(String[] args) {
        Optional<String> configRoute;
        try {
            configRoute = Optional.of(new File("db.properties").getCanonicalPath());
            final Optional<Provider> providers = Optional.of(Provider.MY_SQL);
            ILookupService lookupService = new LookupServiceFactory().lookupService(configRoute, providers);
            System.out.println(lookupService.connectionString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
    }
}
