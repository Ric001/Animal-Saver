package org.animal.savers.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lookup.service.utils.Strings;

public class SqlSessionManager {

    private SqlSessionFactory sqlSessionFactory;
    private static SqlSessionManager manager;
    private static final Logger LOG = Logger.getLogger(SqlSessionManager.class.getName());
    
    private SqlSessionManager() {
    }

    public SqlSession openSession(String route) {
        LOG.info("[ENTERING SqlSession openSession(String route)]");
        if (Objects.isNull(sqlSessionFactory) && !Strings.isNullOrEmpty(route)) {
            try {
                sqlSessionFactory = getSqlSessionFactory(route);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory.openSession();
    }

    public static SqlSessionManager manager() {
        LOG.info("[ENTERING static SqlSessionManager manager()]");
        if (Objects.isNull(manager))
            manager = new SqlSessionManager();
        return manager;
    }

    private SqlSessionFactory getSqlSessionFactory(String route) throws FileNotFoundException {
        LOG.info("[ENTERING SqlSessionFactory getSqlSessionFactory(String route)]");
        final FileInputStream configFile = new FileInputStream(new File(route));
        final SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        LOG.info(String.format("[RETURNING FROM SqlSessionFactory getSqlSessionFactory(String route): %s]", builder));
        return builder.build(configFile);
    }

}