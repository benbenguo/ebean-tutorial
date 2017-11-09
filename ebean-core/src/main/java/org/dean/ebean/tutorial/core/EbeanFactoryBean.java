package org.dean.ebean.tutorial.core;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer> {

    @Autowired
    private ServerConfig serverConfig;

    public ServerConfig getServerConfig() {
        return serverConfig;
    }

    public void setServerConfig(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }

    @Override
    public EbeanServer getObject() throws Exception {
        serverConfig.setName("db");
        serverConfig.loadFromProperties();

//    // set the spring's datasource and transaction manager.
//    config.setDataSource(dataSource);
//    config.setExternalTransactionManager(new SpringAwareJdbcTransactionManager());

        // set as default and register so that Model can be
        // used if desired for save() and update() etc
        serverConfig.setDefaultServer(true);
        serverConfig.setRegister(true);

        return EbeanServerFactory.create(serverConfig);
    }

    @Override
    public Class<?> getObjectType() {
        return EbeanServer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
