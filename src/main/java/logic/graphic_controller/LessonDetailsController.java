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
import logic.bean.DateBean;
import logic.bean.MusicalInstrumentBean;
import logic.bean.PriceBean;
import logic.bean.TimeBean;
import logic.controller.BookingLessonController;
import logic.exception.SyntaxBeanException;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class LessonDetailsController {

    BookingLessonController controller;

    public void setController(BookingLessonController controller){
        this.controller=controller;
    }

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

    @FXML // fx:id="choiceBoxMusicalInstrument"
    private ChoiceBox<String> choiceBoxMusicalInstrument; // Value injected by FXMLLoader

    @FXML // fx:id="choiceBoxPrice"
    private ChoiceBox<String> choiceBoxPrice; // Value injected by FXMLLoader

    @FXML // fx:id="choiceBoxTime"
    private ChoiceBox<String> choiceBoxTime; // Value injected by FXMLLoader

    @FXML // fx:id="datePickerSchedule"
    private DatePicker datePickerSchedule; // Value injected by FXMLLoader

    @FXML // fx:id="sendDetailsButton"
    private Button sendDetailsButton; // Value injected by FXMLLoader


    private String[] musicalInstrumentList = {"guitar", "piano", "sax"};
    private String[] priceList = {"10", "15", "20", "25", "30", "40", "50"};
    private String[] timeList = {"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};


    @FXML
    void goHome(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("home.fxml")));


        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Forza Roma");

        stage.show();

    }

    @FXML
    void goScheduledLessons(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("scheduledLessons.fxml")));


        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Forza Roma");

        stage.show();

    }

    @FXML
    void goLesson(ActionEvent event) throws IOException {
        DateBean dateBean = new DateBean();
        MusicalInstrumentBean musicalInstrumentBean = new MusicalInstrumentBean();
        PriceBean priceBean = new PriceBean();
        TimeBean timeBean = new TimeBean();
        try {
            dateBean.setDate(String.valueOf(datePickerSchedule.getValue()));
            musicalInstrumentBean.setMusicalInstrument((choiceBoxMusicalInstrument.getValue()));
            priceBean.setPrice(choiceBoxPrice.getValue());
            timeBean.setTime(choiceBoxTime.getValue());
        }
        catch (SyntaxBeanException exception){
            datePickerSchedule.setValue(null);
            choiceBoxMusicalInstrument.setValue("");
            choiceBoxPrice.setValue("");
            choiceBoxTime.setValue("");

        }

        if (controller.checkLessonDetails(dateBean,musicalInstrumentBean,priceBean,timeBean)) {
            controller.setBooking(dateBean,musicalInstrumentBean,priceBean,timeBean);
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("lesson.fxml")));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle("Forza Roma");

            stage.show();
        }


    }


    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        choiceBoxMusicalInstrument.getItems().addAll(musicalInstrumentList);
        choiceBoxTime.getItems().addAll(timeList);
        choiceBoxPrice.getItems().addAll(priceList);
        choiceBoxMusicalInstrument.setOnAction(this::getMusicalInstrument);
        choiceBoxPrice.setOnAction(this::getPrice);
        choiceBoxTime.setOnAction(this::getTime);
        datePickerSchedule.setOnAction(this::getSchedule);
        assert Contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert Help != null : "fx:id=\"Help\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert Profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert ScheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert choiceBoxMusicalInstrument != null : "fx:id=\"choiceBoxMusicalInstrument\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert choiceBoxPrice != null : "fx:id=\"choiceBoxPrice\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert choiceBoxTime != null : "fx:id=\"choiceBoxTime\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert datePickerSchedule != null : "fx:id=\"datePickerSchedule\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert sendDetailsButton != null : "fx:id=\"sendDetailsButton\" was not injected: check your FXML file 'lessonDetails.fxml'.";

    }

    private void getSchedule(ActionEvent event) {
        LocalDate schedule = datePickerSchedule.getValue();
    }

    private void getMusicalInstrument(ActionEvent event) {
        String musicalInstrument = choiceBoxMusicalInstrument.getValue();
    }

    private void getPrice(ActionEvent event) {

        String price = choiceBoxPrice.getValue();
    }

    private void getTime(ActionEvent event) {

        String time = choiceBoxTime.getValue();
    }


}

