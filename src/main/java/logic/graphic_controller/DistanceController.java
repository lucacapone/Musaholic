
package logic.graphic_controller;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.ChoiceBox;
        import javafx.scene.control.Label;
        import javafx.scene.input.MouseEvent;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.net.URL;
        import java.util.Objects;
        import java.util.ResourceBundle;

public class DistanceController {

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

    @FXML // fx:id="choiceBoxDistance"
    private ChoiceBox<String> choiceBoxDistance; // Value injected by FXMLLoader

    @FXML // fx:id="choiceBoxPayment"
    private ChoiceBox<String> choiceBoxFaceToFacePayment; // Value injected by FXMLLoader

    @FXML // fx:id="send2Button"
    private Button send2FaceToFaceButton; // Value injected by FXMLLoader

    @FXML // fx:id="statusDistance"
    private Label statusDistance; // Value injected by FXMLLoader

    @FXML // fx:id="statusPayment"
    private Label statusFaceToFacePayment; // Value injected by FXMLLoader

    private String[] distanceList = {"5","10","15","20","25","30"};

    private String[] paymentList = {"10","15","20","25","30","40","50"};


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
    void goFaceToFaceSearchTeacher(ActionEvent event) throws IOException {
        String distance = statusDistance.getText();
        String payment = statusFaceToFacePayment.getText();
        if (payment == "verified" && distance == "verified") {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("home.fxml")));

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
            choiceBoxDistance.getItems().addAll(distanceList);
            choiceBoxFaceToFacePayment.getItems().addAll(paymentList);
            choiceBoxDistance.setOnAction(this::getDistance);
            choiceBoxFaceToFacePayment.setOnAction(this::getPayment);
            assert Contacts != null : "fx:id=\"Contacts\" was not injected: check your FXML file 'distance.fxml'.";
            assert Help != null : "fx:id=\"Help\" was not injected: check your FXML file 'distance.fxml'.";
            assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'distance.fxml'.";
            assert Profile != null : "fx:id=\"Profile\" was not injected: check your FXML file 'distance.fxml'.";
            assert ScheduledLessons != null : "fx:id=\"ScheduledLessons\" was not injected: check your FXML file 'distance.fxml'.";
            assert choiceBoxDistance != null : "fx:id=\"choiceBoxDistance\" was not injected: check your FXML file 'distance.fxml'.";
            assert choiceBoxFaceToFacePayment != null : "fx:id=\"choiceBoxFaceToFacePayment\" was not injected: check your FXML file 'distance.fxml'.";
            assert send2FaceToFaceButton != null : "fx:id=\"send2FaceToFaceButton\" was not injected: check your FXML file 'distance.fxml'.";
            assert statusDistance != null : "fx:id=\"statusDistance\" was not injected: check your FXML file 'distance.fxml'.";
            assert statusFaceToFacePayment != null : "fx:id=\"statusFaceToFacePayment\" was not injected: check your FXML file 'distance.fxml'.";

        }



        private void getPayment (ActionEvent event){
            String payment = choiceBoxFaceToFacePayment.getValue();
            statusFaceToFacePayment.setText("verified");
        }


        private void getDistance (ActionEvent event){
            String distance = choiceBoxDistance.getValue();
            statusDistance.setText("verified");
        }
    }