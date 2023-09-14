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
import logic.exception.DAOException;
import logic.exception.SyntaxBeanException;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

import static logic.graphic_controller.StartController.MUSAHOLIC;

public class LessonDetailsController {

    BookingLessonController controller;

    public void setController(BookingLessonController controller) {
        this.controller = controller;
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

    @FXML // fx:id="choiceBoxMusicalInstrument"
    private ChoiceBox<String> choiceBoxMusicalInstrument; // Value injected by FXMLLoader

    @FXML // fx:id="choiceBoxPrice"
    private ChoiceBox<String> choiceBoxPrice; // Value injected by FXMLLoader

    @FXML // fx:id="choiceBoxTime"
    private ChoiceBox<String> choiceBoxTime; // Value injected by FXMLLoader

    @FXML // fx:id="datePickerSchedule"
    private DatePicker datePickerSchedule; // Value injected by FXMLLoader

    @FXML // fx:id="outLabel"
    private Label outLabel; // Value injected by FXMLLoader
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
        stage.setTitle(MUSAHOLIC);

        stage.show();

    }

    @FXML
    void goScheduledLessons(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("scheduledLessons.fxml")));


        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle(MUSAHOLIC);

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
        } catch (SyntaxBeanException exception) {
            datePickerSchedule.setValue(null);
            choiceBoxMusicalInstrument.setValue("");
            choiceBoxPrice.setValue("");
            choiceBoxTime.setValue("");

        }

        if (controller.checkLessonDetails(dateBean, musicalInstrumentBean, priceBean, timeBean)) {
            try {
                controller.setBooking(dateBean, musicalInstrumentBean, priceBean, timeBean);
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("lesson.fxml")));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.setTitle(MUSAHOLIC);
                if (loader.getController() instanceof LessonController) {
                    LessonController nextGraphicController = loader.getController();
                    nextGraphicController.setController(controller);
                    nextGraphicController.setSatus();
                }

                stage.show();
            } catch (SyntaxBeanException ex) {
                //gestione grafica  errore di sintassi input

                outLabel.setText("Syntax error : retry...");
            } catch (DAOException ex) {
                //gestione grafica del caso di lezione non trovata
                outLabel.setText("No lesson found : change the parameters");
                datePickerSchedule.setValue(null);
                choiceBoxMusicalInstrument.setValue("");
                choiceBoxPrice.setValue("");
                choiceBoxTime.setValue("");
            } catch (SQLException | ClassNotFoundException ex) {
                //gestione grafica del caso di errore nel db connessione
                outLabel.setText("No connected to the Database!");
                datePickerSchedule.setValue(null);
                choiceBoxMusicalInstrument.setValue("");
                choiceBoxPrice.setValue("");
                choiceBoxTime.setValue("");
            }

        } else {
            outLabel.setText("Insert all parameters please");
            datePickerSchedule.setValue(null);
            choiceBoxMusicalInstrument.setValue("");
            choiceBoxPrice.setValue("");
            choiceBoxTime.setValue("");

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
        datePickerSchedule.setEditable(false);
        assert contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert help != null : "fx:id=\"Help\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert home != null : "fx:id=\"Home\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert scheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert choiceBoxMusicalInstrument != null : "fx:id=\"choiceBoxMusicalInstrument\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert choiceBoxPrice != null : "fx:id=\"choiceBoxPrice\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert choiceBoxTime != null : "fx:id=\"choiceBoxTime\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert datePickerSchedule != null : "fx:id=\"datePickerSchedule\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert outLabel != null : "fx:id=\"outLabel\" was not injected: check your FXML file 'lessonDetails.fxml'.";
        assert sendDetailsButton != null : "fx:id=\"sendDetailsButton\" was not injected: check your FXML file 'lessonDetails.fxml'.";

    }

    private LocalDate getSchedule(ActionEvent event) {

        return datePickerSchedule.getValue();
    }

    private String getMusicalInstrument(ActionEvent event) {
        return choiceBoxMusicalInstrument.getValue();
    }

    private String getPrice(ActionEvent event) {

        return choiceBoxPrice.getValue();
    }

    private String getTime(ActionEvent event) {

        return choiceBoxTime.getValue();
    }


}


