package org.lookup.service.service_interface;

import java.util.Properties;

public interface ILookupService {
    
    String connectionString();

    Properties props();
    
    String url();
}