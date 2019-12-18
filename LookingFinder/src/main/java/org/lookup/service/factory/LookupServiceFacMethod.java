package org.lookup.service.factory;

import java.util.Optional;

import org.lookup.service.constants.Provider;
import org.lookup.service.service_interface.ILookupService;

public interface LookupServiceFacMethod {

    ILookupService lookupService(Optional<String> configRoute, Optional<Provider> provider);
    
}