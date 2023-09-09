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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logic.controller.BookingLessonController;

public class HomeController {

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

    @FXML // fx:id="MusicalInstrumentsButton"
    private Button MusicalInstrumentsButton; // Value injected by FXMLLoader

    @FXML // fx:id="NewsButton"
    private Button NewsButton; // Value injected by FXMLLoader

    @FXML // fx:id="Profile"
    private Label Profile; // Value injected by FXMLLoader

    @FXML // fx:id="ScheduleLessonButton"
    private Button BookLessonButton; // Value injected by FXMLLoader

    @FXML // fx:id="ScheduledLessons"
    private Label ScheduledLessons; // Value injected by FXMLLoader


    @FXML
    void StartBookLesson(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("lessonDetails.fxml")));

        BookingLessonController  c = new BookingLessonController();
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("Forza Roma");
        if (loader.getController() instanceof LessonDetailsController){
            LessonDetailsController nextGraphicController=loader.getController();
            nextGraphicController.setController(c);
        }
        stage.show();

    }

    @FXML
    void goHome(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("home.fxml")));


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
        assert Contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'Untitled'.";
        assert Help != null : "fx:id=\"Help\" was not injected: check your FXML file 'Untitled'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'Untitled'.";
        assert MusicalInstrumentsButton != null : "fx:id=\"MusicalInstrumentsButton\" was not injected: check your FXML file 'Untitled'.";
        assert NewsButton != null : "fx:id=\"NewsButton\" was not injected: check your FXML file 'Untitled'.";
        assert Profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'Untitled'.";
        assert BookLessonButton != null : "fx:id=\"BookLessonButton\" was not injected: check your FXML file 'Untitled'.";
        assert ScheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'Untitled'.";

    }

}
