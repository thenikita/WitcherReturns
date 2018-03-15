package com.thenikita.witcherreturns.client.menus;

import com.thenikita.witcherreturns.client.savegame.SaveGameWorker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginScreen {

    public static void BehaveLoginScreen(Stage primaryStage) {

        primaryStage.setTitle("Welcome, Witcher!");


        TextField loginFld = new TextField();
        Text loginSign = new Text("Login");
        loginSign.setWrappingWidth(60);
        HBox loginBox = new HBox();
        loginBox.getChildren().addAll(loginSign, loginFld);
        loginBox.setAlignment(Pos.CENTER);


        TextField passFld = new TextField();
        Text passSign = new Text("Password");
        passSign.setWrappingWidth(60);
        HBox passBox = new HBox();
        passBox.getChildren().addAll(passSign, passFld);
        passBox.setAlignment(Pos.CENTER);


        VBox dataBox = new VBox();
        dataBox.getChildren().addAll(loginBox, passBox);
        dataBox.setAlignment(Pos.CENTER);


        CheckBox offlineChBox = new CheckBox();
        Text offlineSign = new Text("Offline");
        offlineSign.setWrappingWidth(40);


        Button logInBtn = new Button("Log In");
        logInBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String login = loginFld.getText();
                String pass = passFld.getText();
                boolean offline = offlineChBox.isSelected();

                if (PerformLogin(login, pass, offline) && !login.equals("") && !pass.equals("")) {

                    //TODO: perform loading into main menu
                    // close login screen and open mm

                    try {

                        MainMenu.BehaveMainMenu();

                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                    primaryStage.close();
                }
            }
        });

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(offlineChBox, offlineSign, logInBtn);
        buttonBox.setSpacing(30);
        buttonBox.setAlignment(Pos.CENTER);

        dataBox.getChildren().add(buttonBox);
        dataBox.setSpacing(10);

        StackPane rootPane = new StackPane();
        rootPane.getChildren().addAll(dataBox);
        //StackPane.setAlignment(logInBtn, Pos.BOTTOM_RIGHT);
        //StackPane.setAlignment(offlineBox, Pos.CENTER_LEFT);

        primaryStage.setScene(new Scene(rootPane, 300, 150));
        primaryStage.show();
    }


    private static boolean PerformLogin(String login, String pass, boolean offline) {

        System.out.println("Trying to login... With " + login + " : " + pass);

        if (offline && !SaveGameWorker.CheckIfLocalSaveExists()) {

            System.out.println("No local saves found...\n Creatin offline acc!");

            //TODO try to login online or create new acc

            // temporary this is used for passing login screen

            try {

                SaveGameWorker.InitOfflineSave(login, pass);
                return true;

            } catch (Exception e) {

                e.printStackTrace();
            }

        }


        if (offline && SaveGameWorker.CheckIfLocalSaveExists()) {

            System.out.println("Loading offline");
            //TODO login offline


        }


        if (!offline) {

            System.out.println("Trying to login online...");
            //TODO login online

        }

        return false;
    }

}
