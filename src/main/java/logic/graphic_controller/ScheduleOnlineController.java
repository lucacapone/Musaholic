package logic.graphic_controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ScheduleOnlineController {

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

    @FXML // fx:id="choiceBoxOnlineMusicalInstrument"
    private ChoiceBox<String> choiceBoxOnlineMusicalInstrument; // Value injected by FXMLLoader

    @FXML // fx:id="datePickerOnlineSchedule"
    private DatePicker datePickerOnlineSchedule; // Value injected by FXMLLoader

    @FXML // fx:id="sendButton"
    private Button sendButton; // Value injected by FXMLLoader

    @FXML // fx:id="statusOnlineMusicalInstrument"
    private Label statusOnlineMusicalInstrument; // Value injected by FXMLLoader

    @FXML // fx:id="statusOnlineSchedule"
    private Label statusOnlineSchedule; // Value injected by FXMLLoader

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
    void goPayment(ActionEvent event) throws IOException {
        String schedule = statusOnlineSchedule.getText();
        String musicalInstrument = statusOnlineMusicalInstrument.getText();
        if (Objects.equals(schedule, "verified") && Objects.equals(musicalInstrument, "verified")) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("confirmation.fxml")));

            //loader.setControllerFactory(aClass -> new DettaglioAnnuncioController (cp));

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle("Forza Roma");

            stage.show();
        }

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        choiceBoxOnlineMusicalInstrument.getItems().addAll(musicalInstrumentList);
        choiceBoxOnlineMusicalInstrument.setOnAction(this::getMusicalInstrument);
        datePickerOnlineSchedule.setOnAction(this::getSchedule);
        assert Contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'scheduleOnline.fxml'.";
        assert Help != null : "fx:id=\"Help\" was not injected: check your FXML file 'scheduleOnline.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'scheduleOnline.fxml'.";
        assert Profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'scheduleOnline.fxml'.";
        assert ScheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'scheduleOnline.fxml'.";
        assert choiceBoxOnlineMusicalInstrument != null : "fx:id=\"choiceBoxOnlineMusicalInstrument\" was not injected: check your FXML file 'scheduleOnline.fxml'.";
        assert datePickerOnlineSchedule != null : "fx:id=\"datePickerOnlineSchedule\" was not injected: check your FXML file 'scheduleOnline.fxml'.";
        assert sendButton != null : "fx:id=\"sendButton\" was not injected: check your FXML file 'scheduleOnline.fxml'.";
        assert statusOnlineMusicalInstrument != null : "fx:id=\"statusOnlineMusicalInstrument\" was not injected: check your FXML file 'scheduleOnline.fxml'.";
        assert statusOnlineSchedule != null : "fx:id=\"statusOnlineSchedule\" was not injected: check your FXML file 'scheduleOnline.fxml'.";

    }
    private void getSchedule(ActionEvent event) {
        LocalDate schedule = datePickerOnlineSchedule.getValue();
        statusOnlineSchedule.setText("verified");
    }

    private void getMusicalInstrument(ActionEvent event) {
        String musicalInstrument = choiceBoxOnlineMusicalInstrument.getValue();
        statusOnlineMusicalInstrument.setText("verified");
    }

}
