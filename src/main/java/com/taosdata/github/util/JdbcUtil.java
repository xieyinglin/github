package com.taosdata.github.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.taosdata.jdbc.TSDBDriver;

public class JdbcUtil {

    public Connection getConn() throws Exception{

        Class.forName("com.taosdata.jdbc.TSDBDriver");
        String jdbcUrl = "jdbc:TAOS://127.0.0.1:0/db?user=root&password=taosdata";
        Properties connProps = new Properties();
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_USER, "root");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_PASSWORD, "taosdata");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_CONFIG_DIR, "/etc/taos");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_CHARSET, "UTF-8");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_LOCALE, "en_US.UTF-8");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_TIME_ZONE, "UTC-8");
        Connection conn = DriverManager.getConnection(jdbcUrl, connProps);
        return conn;
    }

}