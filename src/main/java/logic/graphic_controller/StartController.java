package logic.graphic_controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.graphic_controller.cli.HomeCLI;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Properties;

public class StartController extends Application {

    public static final String MUSAHOLIC = "Musaholic";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("home.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle(MUSAHOLIC);

        stage.show();

    }

    public static void main(String[] args) throws SQLException, IOException {

//LOGIN NOT IMPLEMENTED, SIMULATED SESSION
        //il caso duso login ha la responsabilità di scrivere su questo file i dati utente


        String name="";
        String surname="";
        String role="";
        String id="";
        String email="";
        FileInputStream propsInput = new FileInputStream("src/main/resources/config.properties");
        Properties prop = new Properties();
        try{
            prop.load(propsInput);
            name=prop.getProperty("name");
            surname=prop.getProperty("surname");
            role=prop.getProperty("role");
            id=prop.getProperty("id");
            email=prop.getProperty("email");

        }
        catch (IOException e) {
          System.out.println("Errore FIle");
        }
        finally {
            propsInput.close();
        }


        boolean isCLI = getView();

        //meccanismo di scelta della grafica
        if (Objects.equals(role, "student")) {

            if (isCLI) {
                HomeCLI homeCLI = new HomeCLI();
                homeCLI.start();
            } else launch(args);
        } else {
            System.out.println("Teacher interface not impelemnented yet");
        }
    }
    public static boolean getView(){
        LocalDate date = LocalDate.now();
        int number = date.getDayOfMonth()%2;
        return number == 1;
    }
}

