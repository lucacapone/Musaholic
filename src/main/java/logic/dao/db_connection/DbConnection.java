package logic.dao.db_connection;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbConnection {
    private static Connection conn = null;

    //aggiunto perché suggerito da SonarCloud in quanto è una Utility Class
    private DbConnection() {
        throw new IllegalStateException("Utility class");
    }

    public static synchronized Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        if (conn == null) {

            try{
                String dbUrl ="";
                String user = "";
                String password ="";
                FileInputStream propsInput = new FileInputStream("src/main/resources/config.properties");
                Properties prop = new Properties();
                prop.load(propsInput);
                dbUrl=prop.getProperty("urlDB");
                user=prop.getProperty("username");
                password=prop.getProperty("password");
                String driverClassName = "com.mysql.jdbc.Driver";
                Class.forName(driverClassName);
                conn = DriverManager.getConnection(dbUrl,user,password);
                propsInput.close();}

            catch (ClassNotFoundException | SQLException | IOException e) {
                Logger logger = Logger.getLogger(DbConnection.class.getName());
                logger.log(Level.WARNING, "Errore durante la connessione al DB");
                throw new SQLException();
            }

        }
        return conn;
    }

}