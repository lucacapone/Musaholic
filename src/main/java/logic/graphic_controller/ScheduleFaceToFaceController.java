package logic.graphic_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class ScheduleFaceToFaceController {

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

    @FXML // fx:id="choiseBoxMusicalIntrument"
    private ChoiceBox<String> choiceBoxFaceToFaceMusicalInstrument; // Value injected by FXMLLoader

    @FXML // fx:id="datePickerSchedule"
    private DatePicker datePickerFaceToFaceSchedule; // Value injected by FXMLLoader


    @FXML // fx:id="sendButton"
    private Button sendFaceToFaceButton; // Value injected by FXMLLoader

    @FXML // fx:id="statusMusicalInstrument"
    private Label statusFaceToFaceMusicalInstrument; // Value injected by FXMLLoader

    @FXML // fx:id="statusSchedule"
    private Label statusFaceToFaceSchedule; // Value injected by FXMLLoader

    private String[] musicalInstrumentList = {"guitar","piano","sax"};

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
    void goDistance(ActionEvent event) throws IOException {
        String schedule = statusFaceToFaceSchedule.getText();
        String musicalInstrument = statusFaceToFaceMusicalInstrument.getText();
        if (schedule == "verified" && musicalInstrument == "verified" ){
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("distance.fxml")));

            //loader.setControllerFactory(aClass -> new DettaglioAnnuncioController (cp));

            Parent root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.setTitle("Forza Roma");

            stage.show();
        }

    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        choiceBoxFaceToFaceMusicalInstrument.getItems().addAll(musicalInstrumentList);
        choiceBoxFaceToFaceMusicalInstrument.setOnAction(this::getMusicalInstrument);
        datePickerFaceToFaceSchedule.setOnAction(this::getSchedule);
        assert Contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'scheduleFaceToFace.fxml'.";
        assert Help != null : "fx:id=\"Help\" was not injected: check your FXML file 'scheduleFaceToFace.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'scheduleFaceToFace.fxml'.";
        assert Profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'scheduleFaceToFace.fxml'.";
        assert ScheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'scheduleFaceToFace.fxml'.";
        assert choiceBoxFaceToFaceMusicalInstrument != null : "fx:id=\"choiceBoxFaceToFaceMusicalInstrument\" was not injected: check your FXML file 'scheduleFaceToFace.fxml'.";
        assert datePickerFaceToFaceSchedule != null : "fx:id=\"datePickerFaceToFaceSchedule\" was not injected: check your FXML file 'scheduleFaceToFace.fxml'.";
        assert sendFaceToFaceButton != null : "fx:id=\"sendFaceToFaceButton\" was not injected: check your FXML file 'scheduleFaceToFace.fxml'.";
        assert statusFaceToFaceMusicalInstrument != null : "fx:id=\"statusFaceToFaceMusicalInstrument\" was not injected: check your FXML file 'scheduleFaceToFace.fxml'.";
        assert statusFaceToFaceSchedule != null : "fx:id=\"statusFaceToFaceSchedule\" was not injected: check your FXML file 'scheduleFaceToFace.fxml'.";


    }

    private void getSchedule(ActionEvent event) {
        LocalDate schedule = datePickerFaceToFaceSchedule.getValue();
        statusFaceToFaceSchedule.setText("verified");
    }

    private void getMusicalInstrument(ActionEvent event) {
        String musicalInstrument = choiceBoxFaceToFaceMusicalInstrument.getValue();
        statusFaceToFaceMusicalInstrument.setText("verified");
    }

}