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

        //the login use case is responsible for writing user data to this file

        String role = "";
        FileInputStream propsInput = new FileInputStream("src/main/resources/config.properties");
        Properties prop = new Properties();
        try {
            prop.load(propsInput);

            role = prop.getProperty("role");


        } catch (IOException e) {
            System.out.println("Errore FIle");
        } finally {
            propsInput.close();
        }


        boolean isCLI = getView();

        //graphics choice mechanism
        if (Objects.equals(role, "student")) {

            if (isCLI) {
                HomeCLI homeCLI = new HomeCLI();
                homeCLI.start();
            } else launch(args);
        } else {
            System.out.println("Teacher interface not impelemnented yet");
        }
    }

    //graphics choice mechanism
    public static boolean getView() {
        LocalDate date = LocalDate.now();
        int number = date.getDayOfMonth() % 2;
        return number == 1;
    }
}

