package webbrowser.project;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IncognitoController implements Initializable {
    @FXML
    TextArea textArea;
    @FXML
    private Pane pane;

    @FXML
    private WebView webView;

    @FXML
    private  javafx.scene.control.TextField textField;

    @FXML
    private javafx.scene.control.Button sea;


    @FXML
    private javafx.scene.control.TextField textfield2;

    @FXML
    private Label labels;

    @FXML
    private javafx.scene.control.Button searchButton;

    @FXML
    private javafx.scene.control.Button home;

    @FXML
    private Button about;

    @FXML
    private Button window;


    private WebEngine engine;


    private WebHistory history;

    private String homePage;

    private double webZoom;

    private double size;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        engine = webView.getEngine();
        //homePage = "www.google.com";
        //textField.setText(homePage);
        webZoom = 1;
        size = 1;
        pane.setVisible(false);
        //loadPage();
        System.out.println(engine.getUserAgent());

    }

    public void loadPage(){

        //engine.load("http://www.google.com");
        //engine.load("http://"+textField.getText());
        //imageinsert.setVisible(true);
        textfield2.setVisible(false);
        searchButton.setVisible(false);
    }


    @FXML
    private void searchButtonAction(ActionEvent event) {

        if (!textfield2.getText().equals("") && textfield2.getText().startsWith("www") && textfield2.getText().endsWith(".com")) {
            engine.load("http://" + textfield2.getText());
            loadPage();
            labels.setVisible(false);


        } else if(!textfield2.getText().equals("")){
            engine.load("http://www." + textfield2.getText() + ".com");
            loadPage();
            labels.setVisible(false);

        }


    }

    @FXML
    private void seaButtonAction(ActionEvent event) {

        if (!textField.getText().equals("") && textField.getText().startsWith("www") && textField.getText().endsWith(".com")) {
            engine.load("http://" + textField.getText());
            loadPage();
            labels.setVisible(false);



        }
        else if(!textField.getText().equals("")){
            engine.load("http://www." + textField.getText() + ".com");
            loadPage();
            labels.setVisible(false);

        }
    }


    public void refreshPage(){
        //pane.setVisible(false);
        engine.reload();
    }

    public void zoomIn(){
        webZoom += 0.25;
        webView.setZoom(webZoom);
    }

    public void zoomOut(){
        webZoom -= 0.25;
        webView.setZoom(webZoom);
    }

    @FXML
    private void homeAction(ActionEvent event) throws IOException
    {
        pane.setVisible(false);
        try{
            Parent r = FXMLLoader.load(getClass().getResource("WebPage.fxml"));
            Scene scene = new Scene(r);
            Stage HomeStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            //HomeStage.setScene(scene);
            // HomeStage.initStyle(StageStyle.UNDECORATED);
            HomeStage.setScene(scene);
            HomeStage.show();
            HomeStage.setResizable(false);
            HomeStage.setTitle("SSS Browser");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void displayHistory() throws IOException {

        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Incognito History.txt",true));
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        pane.setVisible(true);
        textArea.clear();
        textArea.appendText( "No history " + "\n");

        //for (WebHistory.Entry entry : entries){

            //System.out.println(entry);
            //System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
            //bufferedWriter.write(entry.getUrl() + " " + entry.getLastVisitedDate() + "\n");
            //bufferedWriter.flush();
            //bufferedWriter.close();
            //textArea.appendText( "No history " + "\n");
        //}

    }

    public void back() {
        pane.setVisible(false);
        try {
            history = engine.getHistory();
            ObservableList<WebHistory.Entry> entries = history.getEntries();
            //for (WebHistory.Entry entry : entries)
            //{
            //System.out.println(entry.getUrl() + " " +entry.getLastVisitedDate());
            //
            history.go(-1);
            textField.setText(entries.get(history.getCurrentIndex()).getUrl());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }


    public void forward() {
        pane.setVisible(false);
        try {
            history = engine.getHistory();
            ObservableList<WebHistory.Entry> entries = history.getEntries();
            history.go(1);
            textField.setText(entries.get(history.getCurrentIndex()).getUrl());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }


    @FXML
    private void windowAction(ActionEvent event)throws IOException{

        Parent rot =FXMLLoader.load(getClass().getResource("WebPage.fxml"));
        Scene scene = new Scene(rot);
        Stage WindowStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //HomeStage.setScene(scene);
        //HomeStage.initStyle(StageStyle.UNDECORATED);
        WindowStage.setScene(scene);
        WindowStage.show();
    }

    @FXML
    private void exit_history (ActionEvent event){
        pane.setVisible(false);

    }

}

