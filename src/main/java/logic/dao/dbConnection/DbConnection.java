package logic.dao.dbConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbConnection {
    private static Connection conn = null;

    //aggiunto perché suggerito da SonarCloud in quanto è una Utility Class
    private DbConnection() {
        throw new IllegalStateException("Utility class");
    }

    public static synchronized Connection getConnection() {
        if (conn == null) {
            try(
                    FileReader fr = new FileReader("src/main/resources/utenze/db.txt");
                    BufferedReader in = new BufferedReader(fr)
            ){
                String user;
                String password;
                String line;
                String[] userPasswordArray;
                line = in.readLine();
                userPasswordArray = line.split(" ");
                user = userPasswordArray[0];
                password = "";
                String dbUrl = "jdbc:mysql://localhost/musaholicdb";
                String driverClassName = "com.mysql.jdbc.Driver";
                Class.forName(driverClassName);
                conn = DriverManager.getConnection(dbUrl,user,password);

            }
            catch (ClassNotFoundException | SQLException | IOException e) {
                Logger logger = Logger.getLogger(DbConnection.class.getName());
                logger.log(Level.WARNING, "Errore durante la connessione al DB");
            }

        }
        return conn;
    }

}