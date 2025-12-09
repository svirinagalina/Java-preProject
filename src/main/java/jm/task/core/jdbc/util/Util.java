package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/kata_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ufkbyf";

    private static Connection connection;

    // ===== JDBC =====
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ===== Hibernate =====
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure()              // ищет hibernate.cfg.xml в classpath
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка создания SessionFactory", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
