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

import static logic.graphic_controller.StartController.MUSAHOLIC;

public class HomeController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Contacts"
    private Label contacts; // Value injected by FXMLLoader

    @FXML // fx:id="Help"
    private Label help; // Value injected by FXMLLoader

    @FXML // fx:id="Home"
    private Label home; // Value injected by FXMLLoader

    @FXML // fx:id="MusicalInstrumentsButton"
    private Button musicalInstrumentsButton; // Value injected by FXMLLoader

    @FXML // fx:id="NewsButton"
    private Button newsButton; // Value injected by FXMLLoader

    @FXML // fx:id="Profile"
    private Label profile; // Value injected by FXMLLoader

    @FXML // fx:id="ScheduleLessonButton"
    private Button bookLessonButton; // Value injected by FXMLLoader

    @FXML // fx:id="ScheduledLessons"
    private Label scheduledLessons; // Value injected by FXMLLoader


    @FXML
    void startBookLesson(ActionEvent event) throws IOException {
        BookingLessonController  controller = new BookingLessonController();
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("lessonDetails.fxml")));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle(MUSAHOLIC);
            if (loader.getController() instanceof LessonDetailsController) {
                LessonDetailsController nextGraphicController = loader.getController();
                nextGraphicController.setController(controller);
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
        stage.setTitle("Forza Roma");

        stage.show();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'Untitled'.";
        assert help != null : "fx:id=\"Help\" was not injected: check your FXML file 'Untitled'.";
        assert home != null : "fx:id=\"Home\" was not injected: check your FXML file 'Untitled'.";
        assert musicalInstrumentsButton != null : "fx:id=\"MusicalInstrumentsButton\" was not injected: check your FXML file 'Untitled'.";
        assert newsButton != null : "fx:id=\"NewsButton\" was not injected: check your FXML file 'Untitled'.";
        assert profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'Untitled'.";
        assert bookLessonButton != null : "fx:id=\"BookLessonButton\" was not injected: check your FXML file 'Untitled'.";
        assert scheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'Untitled'.";

    }

}
