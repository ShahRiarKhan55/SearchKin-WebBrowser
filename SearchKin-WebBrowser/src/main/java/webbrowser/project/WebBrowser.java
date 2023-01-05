package webbrowser.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WebBrowser extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent r = FXMLLoader.load(getClass().getResource("Webpage.fxml"));
        stage.setTitle("SearchKin Browser");
        stage.setScene(new Scene(r));
        stage.show();
        //stage.setResizable(false);
        //stage.setFullScreen(true);
        //stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}