package logic.graphic_controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StartController extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("home.fxml")));

        //loader.setControllerFactory(aClass -> new DettaglioAnnuncioController (cp));

        Parent root = loader.load();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("Musaholic");

        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

