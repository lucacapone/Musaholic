package logic.graphic_controller;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ConfirmationController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Contacts"
    private Label Contacts; // Value injected by FXMLLoader

    @FXML // fx:id="Help"
    private Label Help; // Value injected by FXMLLoader

    @FXML // fx:id="Home"
    private Label Home; // Value injected by FXMLLoader

    @FXML // fx:id="Profile"
    private Label Profile; // Value injected by FXMLLoader

    @FXML // fx:id="ScheduledLessons"
    private Label ScheduledLessons; // Value injected by FXMLLoader

    @FXML // fx:id="noButton"
    private Button noButton; // Value injected by FXMLLoader

    @FXML // fx:id="yesButton"
    private Button yesButton; // Value injected by FXMLLoader




    @FXML
    void goSavedLesson(ActionEvent event) {

    }




    @FXML
    void goHome(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("home.fxml")));

        //loader.setControllerFactory(aClass -> new DettaglioAnnuncioController (cp));

        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("Forza Roma");

        stage.show();

    }
    @FXML
    void goScheduledLessons(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("scheduledLessons.fxml")));

        //loader.setControllerFactory(aClass -> new DettaglioAnnuncioController (cp));

        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("Forza Roma");

        stage.show();

    }

    @FXML
    void goLesson(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("lesson.fxml")));

            //loader.setControllerFactory(aClass -> new DettaglioAnnuncioController (cp));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle("Forza Roma");

            stage.show();



    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert Help != null : "fx:id=\"Help\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert Profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert ScheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert noButton != null : "fx:id=\"noButton\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert yesButton != null : "fx:id=\"yesButton\" was not injected: check your FXML file 'confirmation.fxml'.";

    }

}
