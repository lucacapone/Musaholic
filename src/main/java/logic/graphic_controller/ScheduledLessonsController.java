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

import static logic.graphic_controller.StartController.MUSAHOLIC;

public class ScheduledLessonsController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Contacts"
    private Label contacts; // Value injected by FXMLLoader

    @FXML // fx:id="DateLesson"
    private TableColumn<Lesson,LocalDate> dateLesson; // Value injected by FXMLLoader

    @FXML // fx:id="DistanceLesson"
    private TableColumn<Lesson,String> distanceLesson; // Value injected by FXMLLoader

    @FXML // fx:id="DoneLesson"
    private TableColumn<Lesson,Boolean> doneLesson; // Value injected by FXMLLoader

    @FXML // fx:id="Help"
    private Label help; // Value injected by FXMLLoader

    @FXML // fx:id="Home"
    private Label home; // Value injected by FXMLLoader

    @FXML // fx:id="ModeLesson"
    private TableColumn<Lesson, String> modeLesson; // Value injected by FXMLLoader

    @FXML // fx:id="MusicalInstrumentLesson"
    private TableColumn<Lesson, String> musicalInstrumentLesson; // Value injected by FXMLLoader

    @FXML // fx:id="NumberLesson"
    private TableColumn<Lesson, Integer> numberLesson; // Value injected by FXMLLoader

    @FXML // fx:id="PaymentLesson"
    private TableColumn<Lesson, String> paymentLesson; // Value injected by FXMLLoader

    @FXML // fx:id="Profile"
    private Label profile; // Value injected by FXMLLoader

    @FXML // fx:id="ScheduledLessons"
    private Label scheduledLessons; // Value injected by FXMLLoader

    @FXML // fx:id="TeacherLesson"
    private TableColumn<Lesson, String> teacherLesson; // Value injected by FXMLLoader

    @FXML
    void goHome(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("home.fxml")));



        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle(MUSAHOLIC);

        stage.show();

    }
    @FXML
    void goScheduledLessons(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("scheduledLessons.fxml")));


        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle(MUSAHOLIC);

        stage.show();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        numberLesson.setCellValueFactory(new PropertyValueFactory<Lesson,Integer>("number"));
        modeLesson.setCellValueFactory(new PropertyValueFactory<Lesson,String>("mode"));
        dateLesson.setCellValueFactory(new PropertyValueFactory<Lesson,LocalDate>("date"));
        musicalInstrumentLesson.setCellValueFactory(new PropertyValueFactory<Lesson,String>("musicalInstrument"));
        paymentLesson.setCellValueFactory(new PropertyValueFactory<Lesson,String>("payment"));
        distanceLesson.setCellValueFactory(new PropertyValueFactory<Lesson,String>("distance"));
        teacherLesson.setCellValueFactory(new PropertyValueFactory<Lesson,String>("teacher"));
        doneLesson.setCellValueFactory(new PropertyValueFactory<Lesson,Boolean>("done"));
        assert contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert dateLesson != null : "fx:id=\"DateLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert distanceLesson != null : "fx:id=\"DistanceLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert doneLesson != null : "fx:id=\"DoneLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert help != null : "fx:id=\"Help\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert home != null : "fx:id=\"Home\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert modeLesson != null : "fx:id=\"ModeLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert musicalInstrumentLesson != null : "fx:id=\"MusicalInstrumentLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert numberLesson != null : "fx:id=\"NumberLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert paymentLesson != null : "fx:id=\"PaymentLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert scheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'scheduledLessons.fxml'.";
        assert teacherLesson != null : "fx:id=\"TeacherLesson\" was not injected: check your FXML file 'scheduledLessons.fxml'.";

    }

}
