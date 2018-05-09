package ru.babudzhi;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class MyContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Ура! Приложение стартануло ");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Ура! Приложение финишировало ");
    }
}
