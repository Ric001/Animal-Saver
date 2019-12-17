package org.lookup.service.factory;

import java.util.logging.Logger;

import org.lookup.service.service_interface.ILookupService;

public class LookupServiceFactory implements LookupServiceFacMethod {

    private final static Logger LOG = Logger.getLogger(LookupServiceFacMethod.class.getName());
    
    @Override
    public ILookupService lookupService() {
        LOG.info("[ENTERING ILookupService lookupService()]");
        return null;
    }
    
} 