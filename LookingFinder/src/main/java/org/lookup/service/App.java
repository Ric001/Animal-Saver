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
            final ILookupService lookupService = new LookupServiceFactory().lookupService(configRoute, providers);
            System.out.println("{PROPERTIES -> " + lookupService.props() + "}");
            System.out.println("{Connection String -> " + lookupService.connectionString() + "}");
            System.out.println("{URL -> " + lookupService.url() + "}");
            System.out.println("{Driver Name -> " + lookupService.driverVendorName() + "}");
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }
}
