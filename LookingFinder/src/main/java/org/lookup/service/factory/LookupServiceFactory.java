package org.lookup.service.factory;

import java.util.Optional;
import java.util.logging.Logger;

import org.lookup.service.constants.Provider;
import org.lookup.service.service_interface.ILookupService;
import org.lookup.service.service_interface.LookupService;

public class LookupServiceFactory implements LookupServiceFacMethod {

    private final static Logger LOG = Logger.getLogger(LookupServiceFacMethod.class.getName());
    
    @Override
    public ILookupService lookupService(Optional<String> configRoute, Optional<Provider> provider) {
        LOG.info("[ENTERING ILookupService lookupService()]");
        return new LookupService(configRoute, provider);
    }
    
} 