package com.thenikita.witcherreturns.client.menus;

import com.thenikita.witcherreturns.client.SaveGameWorker;
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

        primaryStage.setTitle("Hello! Log in Please!");


        TextField loginFld = new TextField();
        Text loginText = new Text("Login");
        loginText.setWrappingWidth(60);
        HBox loginBox = new HBox();
        loginBox.getChildren().addAll(loginText, loginFld);
        loginBox.setAlignment(Pos.CENTER);


        TextField passFld = new TextField();
        Text passText = new Text("Password");
        passText.setWrappingWidth(60);
        HBox passBox = new HBox();
        passBox.getChildren().addAll(passText, passFld);
        passBox.setAlignment(Pos.CENTER);


        VBox dataBox = new VBox();
        dataBox.getChildren().addAll(loginBox, passBox);
        dataBox.setAlignment(Pos.CENTER);


        CheckBox offlineChBox = new CheckBox();
        Text offlineText = new Text("Offline");
        offlineText.setWrappingWidth(40);
        HBox offlineBox = new HBox();
        offlineBox.getChildren().addAll(offlineChBox, offlineText);
        offlineBox.setAlignment(Pos.BOTTOM_LEFT);


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
        buttonBox.getChildren().addAll(logInBtn);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);


        StackPane rootPane = new StackPane();
        rootPane.getChildren().addAll(dataBox, offlineBox, buttonBox);
        //StackPane.setAlignment(logInBtn, Pos.BOTTOM_RIGHT);
        //StackPane.setAlignment(offlineBox, Pos.CENTER_LEFT);

        primaryStage.setScene(new Scene(rootPane, 300, 150));
        primaryStage.show();
    }


    private static boolean PerformLogin(String login, String pass, boolean offline) {

        System.out.println("Trying to login... With " + login + " : " + pass);
        if (offline && !SaveGameWorker.CheckIfLocalSaveExists()) {

            System.out.println("No local saves found...\n Looking online...");

            //TODO try to login online or create new acc

        } else if (offline) {

            System.out.println("Loging offline");
            //TODO login offline

        } else if (!offline) {

            System.out.println("Trying to login online...");
            //TODO login online

        }

        return false;
    }

}
