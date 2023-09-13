package logic.graphic_controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.graphic_controller.cli.HomeCLI;
import logic.model.Session;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

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

    public static void main(String[] args) {

//LOGIN NOT IMPLEMENTED, SIMULATED SESSION
        Session session = Session.getInstance();
        session.setEmail("utente1@gmail.com");
        session.setId("S12");
        session.setName("utenteNome");
        session.setRole("student");
        session.setSurname("utenteCognome");

        boolean isCLI = getView();
        String role = session.getRole();

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
        return number == 0;
    }
}

