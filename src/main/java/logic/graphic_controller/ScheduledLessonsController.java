package logic.graphic_controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logic.model.Lesson;

public class ScheduledLessonsController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Contacts"
    private Label Contacts; // Value injected by FXMLLoader

    @FXML // fx:id="DateLesson"
    private TableColumn<Lesson,LocalDate> DateLesson; // Value injected by FXMLLoader

    @FXML // fx:id="DistanceLesson"
    private TableColumn<Lesson,String> DistanceLesson; // Value injected by FXMLLoader

    @FXML // fx:id="DoneLesson"
    private TableColumn<Lesson,Boolean> DoneLesson; // Value injected by FXMLLoader

    @FXML // fx:id="Help"
    private Label Help; // Value injected by FXMLLoader

    @FXML // fx:id="Home"
    private Label Home; // Value injected by FXMLLoader

    @FXML // fx:id="ModeLesson"
    private TableColumn<Lesson, String> ModeLesson; // Value injected by FXMLLoader

    @FXML // fx:id="MusicalInstrumentLesson"
    private TableColumn<Lesson, String> MusicalInstrumentLesson; // Value injected by FXMLLoader

    @FXML // fx:id="NumberLesson"
    private TableColumn<Lesson, Integer> NumberLesson; // Value injected by FXMLLoader

    @FXML // fx:id="PaymentLesson"
    private TableColumn<Lesson, String> PaymentLesson; // Value injected by FXMLLoader

    @FXML // fx:id="Profile"
    private Label Profile; // Value injected by FXMLLoader

    @FXML // fx:id="ScheduledLessons"
    private Label ScheduledLessons; // Value injected by FXMLLoader

    @FXML // fx:id="TeacherLesson"
    private TableColumn<Lesson, String> TeacherLesson; // Value injected by FXMLLoader

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


        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("Forza Roma");

        stage.show();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        NumberLesson.setCellValueFactory(new PropertyValueFactory<Lesson,Integer>("number"));
        ModeLesson.setCellValueFactory(new PropertyValueFactory<Lesson,String>("mode"));
        DateLesson.setCellValueFactory(new PropertyValueFactory<Lesson,LocalDate>("date"));
        MusicalInstrumentLesson.setCellValueFactory(new PropertyValueFactory<Lesson,String>("musicalInstrument"));
        PaymentLesson.setCellValueFactory(new PropertyValueFactory<Lesson,String>("payment"));
        DistanceLesson.setCellValueFactory(new PropertyValueFactory<Lesson,String>("distance"));
        TeacherLesson.setCellValueFactory(new PropertyValueFactory<Lesson,String>("teacher"));
        DoneLesson.setCellValueFactory(new PropertyValueFactory<Lesson,Boolean>("done"));
        assert Contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert DateLesson != null : "fx:id=\"DateLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert DistanceLesson != null : "fx:id=\"DistanceLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert DoneLesson != null : "fx:id=\"DoneLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert Help != null : "fx:id=\"Help\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert ModeLesson != null : "fx:id=\"ModeLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert MusicalInstrumentLesson != null : "fx:id=\"MusicalInstrumentLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert NumberLesson != null : "fx:id=\"NumberLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert PaymentLesson != null : "fx:id=\"PaymentLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert Profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert ScheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert TeacherLesson != null : "fx:id=\"TeacherLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";

    }

}
