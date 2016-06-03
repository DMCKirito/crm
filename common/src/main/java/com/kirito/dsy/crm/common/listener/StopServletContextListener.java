package com.kirito.dsy.crm.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.util.Enumeration;

/**
 * Created by Kirito on 16/6/1.
 */
public class StopServletContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            com.mysql.jdbc.AbandonedConnectionCleanupThread.shutdown();
        } catch (Throwable t) {}
        // This manually deregisters JDBC driver, which prevents Tomcat 7 from complaining about memory leaks
        Enumeration<Driver> drivers = java.sql.DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                java.sql.DriverManager.deregisterDriver(driver);
            } catch (Throwable t) {}
        }
        try { Thread.sleep(2000L); } catch (Exception e) {}
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }
}
