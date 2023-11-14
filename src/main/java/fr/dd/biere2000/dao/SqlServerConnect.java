package fr.dd.biere2000.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerConnect {
    private static Connection connection;
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=SDBM";
    private static String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String utilisateur = "sa";
    private static String motDePasse = "azerty@123456";

    public SqlServerConnect() {
    }

    public static Connection getInstance(){
        if (connection == null) {
            try {
                Class.forName(className);
                connection = DriverManager.getConnection(url, utilisateur, motDePasse);
                System.out.println("Connexion Ok");
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver not found...");
            } catch ( SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return connection;
    }
}
