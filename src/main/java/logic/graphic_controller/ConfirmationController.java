package logic.graphic_controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import logic.bean.IndexChoseBean;
import logic.controller.BookingLessonController;
import logic.exception.DAOException;


import static logic.graphic_controller.StartController.MUSAHOLIC;

public class ConfirmationController {

    BookingLessonController controller;

    public void setController(BookingLessonController controller){
        this.controller=controller;
    }

    private IndexChoseBean indexChoseBean;

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

    @FXML // fx:id="Profile"
    private Label profile; // Value injected by FXMLLoader

    @FXML // fx:id="ScheduledLessons"
    private Label scheduledLessons; // Value injected by FXMLLoader

    @FXML // fx:id="finalLessonLabel"
    private Label finalLessonLabel; // Value injected by FXMLLoader

    @FXML // fx:id="noButton"
    private Button noButton; // Value injected by FXMLLoader

    @FXML // fx:id="yesButton"
    private Button yesButton; // Value injected by FXMLLoader

    @FXML // fx:id="outLabel"
    private Label outLabel; // Value injected by FXMLLoader

    @FXML
    void goSavedLesson(ActionEvent event) throws Exception {


        try {
            controller.setTeacherDetails(indexChoseBean);
            controller.saveLesson();
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("home.fxml")));

            Parent root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.setTitle(MUSAHOLIC);

            stage.show();
        }
        catch(DAOException exception){
            //gestione grafica del caso di lezione non trovata
            outLabel.setText("No lesson saved : sorry, try again later");
        }
        catch(SQLException s){
            //gestione grafica del caso di errore nel db connessione
            outLabel.setText("No connected to the Database!");
        }

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
        stage.setTitle(MUSAHOLIC);

        stage.show();

    }

    @FXML
    void goLesson(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("lesson.fxml")));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle("Forza Roma");

        if (loader.getController() instanceof LessonController){
            LessonController nextGraphicController=loader.getController();
            nextGraphicController.setController(controller);
            nextGraphicController.setSatus();
        }

            stage.show();



    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert help != null : "fx:id=\"Help\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert home != null : "fx:id=\"Home\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert scheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert finalLessonLabel != null : "fx:id=\"finalLessonLabel\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert noButton != null : "fx:id=\"noButton\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert yesButton != null : "fx:id=\"yesButton\" was not injected: check your FXML file 'confirmation.fxml'.";
        assert outLabel != null : "fx:id=\"outLabel\" was not injected: check your FXML file 'confirmation.fxml'.";
    }

    public void setStatus(IndexChoseBean index, String finalLesson) {
        finalLessonLabel.setText(finalLesson);
        this.indexChoseBean = index;
    }
}
  
