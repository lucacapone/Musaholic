package logic.graphic_controller;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logic.bean.TeacherChoseBean;
import logic.controller.BookingLessonController;
import logic.exception.SyntaxBeanException;

import static logic.graphic_controller.StartController.MUSAHOLIC;

public class LessonController {

    BookingLessonController controller;

    public void setController(BookingLessonController controller){
        this.controller=controller;
    }

    private String finalLesson;

    private TeacherChoseBean indexChoseBean;


    public String getFinalLesson() {
        return finalLesson;
    }

    public void setFinalLesson(String finalLesson) {
        this.finalLesson = finalLesson;
    }

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

    @FXML // fx:id="backButtton"
    private Button backButtton; // Value injected by FXMLLoader

    @FXML // fx:id="confirmButton"
    private Button confirmButton; // Value injected by FXMLLoader

    @FXML // fx:id="lessonListView"
    private ListView<String> lessonListView; // Value injected by FXMLLoader

    @FXML // fx:id="resultLabel"
    private Label resultLabel; // Value injected by FXMLLoader

    @FXML
    void goConfirmation(ActionEvent event) throws IOException {
        if (checkSelected()) {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("confirmation.fxml")));


            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle(MUSAHOLIC);
            if (loader.getController() instanceof ConfirmationController) {
                ConfirmationController nextGraphicController = loader.getController();
                nextGraphicController.setController(controller);
                nextGraphicController.setStatus(indexChoseBean, finalLesson);
            }

            stage.show();
        }
        else {
            resultLabel.setText("first select a lesson, please");
        }

    }

    private boolean checkSelected() {
        return !Objects.equals(resultLabel.getText(), "") && !Objects.equals(resultLabel.getText(), "first select a lesson, please");
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
    void goLessonDetails(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("lessonDetails.fxml")));


        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle(MUSAHOLIC);
        if (loader.getController() instanceof LessonDetailsController){
            LessonDetailsController nextGraphicController=loader.getController();
            nextGraphicController.setController(controller);
        }

        stage.show();

    }


    @FXML
    void showLesson(MouseEvent event) throws SyntaxBeanException {
        // mettere la stringa lesson
        resultLabel.setText(lessonListView.getSelectionModel().getSelectedItem());
        finalLesson = lessonListView.getSelectionModel().getSelectedItem();
        TeacherChoseBean index = new TeacherChoseBean();
        index.setIndex(String.valueOf(lessonListView.getSelectionModel().getSelectedIndex()));
        indexChoseBean = index;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'mode.fxml'.";
        assert help != null : "fx:id=\"Help\" was not injected: check your FXML file 'mode.fxml'.";
        assert home != null : "fx:id=\"Home\" was not injected: check your FXML file 'mode.fxml'.";
        assert profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'mode.fxml'.";
        assert scheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'mode.fxml'.";
        assert backButtton != null : "fx:id=\"backButtton\" was not injected: check your FXML file 'mode.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file 'mode.fxml'.";
        assert lessonListView != null : "fx:id=\"lessonListView\" was not injected: check your FXML file 'mode.fxml'.";

    }

    public void setSatus() {
        List<String> listaStringhe = new ArrayList<>();
        controller.getLessonList().forEach(obj -> {
            String stringa = obj.getLesson()+"     classroom: "+controller.getClassroom().getClassroom();
            listaStringhe.add(stringa);
        });
        ObservableList<String> items = FXCollections.observableArrayList(listaStringhe);
        lessonListView.setItems(items);
    }
}