package org.lookup.service.service_interface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;

import org.lookup.service.constants.DBLinks;
import org.lookup.service.constants.Provider;
import org.lookup.service.utils.Strings;

public class LookupService implements ILookupService {

    private String configurationRoute;
    private String db;
    private DBLinks connectionLink;
    private String username;
    private String password;
    private String conectionString;
    private String host;
    private String port;
    private Properties props;
    private String driverName;

    private final static Logger LOG = Logger.getLogger(LookupService.class.getName());

    public LookupService(Optional<String> configRoute, Optional<Provider> dbEngineProvider) {
        if (Strings.isNullOrEmpty(configRoute))
            configurationRoute = configRoute.get();
        if (Objects.nonNull(dbEngineProvider) && dbEngineProvider.isPresent())
            setLinkProvider(dbEngineProvider.get());
         loadFromProperties(loadDataByRoute(configurationRoute));
    }

    
    public void setLinkProvider(Provider provider) {
        LOG.info("[ENTERING void setLinkProvider(Provider provider)]");
        if (Objects.isNull(provider))
            return;
        switch (provider) {
        case MY_SQL:
            connectionLink = DBLinks.MY_SQL_DB_LINK;
            break;
        default:
            connectionLink = DBLinks.UNSUPPORTED_DB_LINK;
        }
        LOG.info(String.format("[RETURNING FROM void setLinkProvider(Provider provider): %s]", connectionLink));
    }

    public Properties loadDataByRoute(final String configRoute) {
        LOG.info("[ENTERING void localizeDate(final String configRoute)]");
        final Properties dbConfigProps = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(new File(configRoute));
            dbConfigProps.load(in);
            props = dbConfigProps;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dbConfigProps;
    }

    public void loadFromProperties(final Properties properties) {
        LOG.info("[ENTERING void loadFromProperties(final Properties properties)]");
        if (!properties.isEmpty()) {
            db = properties.getProperty("db");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            host = properties.getProperty("host");
            port = properties.getProperty("port");
            driverName = properties.getProperty("driver");
        }
    }

    @Override
    public String connectionString() {
        LOG.info("[ENTERING String connectionString()]");
        final StringBuilder builder = new StringBuilder();
        builder.append(connectionLink).append(host).append(":").append(port).append("/").append(db).append("/?user=")
                .append(username).append("&password=").append(password);
        conectionString = builder.toString();
        LOG.info(String.format("[RETURNING FROM String connectionString(): %s]", conectionString));
        return conectionString;
    }


    @Override
    public Properties props() {
        LOG.info("[RETURNING FROM Properties props()]");
        return props;
    }

    @Override
    public String url() {
        LOG.info("[ENTERING ON String url()]");
        StringBuilder builder = new StringBuilder();
        builder.append(connectionLink.toString()).append(host).append(":").append(port).append("/").append(db)
                .append("/");
        LOG.info(String.format("[RETURNING FROM String url(): %s]", builder.toString()));
        return builder.toString();
    }

    @Override
    public String driverVendorName() {
        LOG.info(String.format("[ENTERING ON driverVendorName() : %s]", driverName));
        return driverName;
    }
}