package logic.graphic_controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.graphic_controller.CLI.HomeCLI;

import java.io.IOException;
import java.util.Objects;

public class StartController extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("home.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("Musaholic");

        stage.show();

    }

    public static void main(String[] args) {

        boolean isCLI = true;

        //meccanismo di scelta

        if (isCLI) {
            HomeCLI homeCLI = new HomeCLI();
            homeCLI.start();
        } else launch(args);
    }
}

