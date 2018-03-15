package com.thenikita.witcherreturns.client;

import com.thenikita.witcherreturns.client.menus.LoginScreen;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class WRClient extends Application {

    public static Session gameSession = new Session();

    public static void main(String args[]){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        LoginScreen.BehaveLoginScreen(primaryStage);
    }

}
