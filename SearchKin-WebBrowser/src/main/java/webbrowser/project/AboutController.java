package webbrowser.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {

    @FXML
    private TextField textField;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private javafx.scene.control.Label text;

    @FXML
    private javafx.scene.control.Button backtobrowser;


    String words;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image images1 = new Image(getClass().getResourceAsStream("Images/Sumaiya.jpg"));
        image1.setImage(images1);

        Image images3 = new Image(getClass().getResourceAsStream("Images/Adib.jpg"));
        image3.setImage(images3);

        Image images2 = new Image(getClass().getResourceAsStream("Images/Siam.jpg"));
        image2.setImage(images2);

        words="The web browser named “SearchKin” is a software application for retrieving,\n" +"presenting and traversing information resources on the World Wide Web.\n"+"Hyperlinks present in resources enables the user of this browser to easily\n"+"navigate to their related resources. The browser’s main functionality is to present\n"+"the web resource the user chooses, by requesting it from the server\n"+"and displaying it on the browser window. It helps retrieve the information from\n"+"its vast reservoir viz. internet. It allows collaborators in remote sites\n"+"to share their ideas and all aspects of a common project. \n"+"This browser is developed in Intellij IDEA using JavaFX and File.\n"+"Using this software, companies and users can improve the efficiency of their services.";
        text.setText(words);


    }

    @FXML
    private void backBrowser(ActionEvent event)throws IOException {

        Parent r = FXMLLoader.load(getClass().getResource("Webpage.fxml"));
        Scene scene = new Scene(r);
        Stage HomeStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //HomeStage.setScene(scene);
        //HomeStage.initStyle(StageStyle.UNDECORATED);
        HomeStage.setScene(scene);
        HomeStage.show();
    }
}
