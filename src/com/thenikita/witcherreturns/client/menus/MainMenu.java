package com.thenikita.witcherreturns.client.menus;

import com.thenikita.witcherreturns.client.NoSavedGameException;
import com.thenikita.witcherreturns.client.SaveGameWorker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class MainMenu {

    public static void BehaveMainMenu() throws Exception {

        Stage mainMenuStage = new Stage();
        mainMenuStage.setTitle("Main Menu");

        Button startBtn = new Button("Start game");
        startBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                System.out.println("Starting the game...");

                try {

                    SaveGameWorker.LoadGame();

                } catch (NoSavedGameException e) {

                    e.printStackTrace();
                }
            }
        });

        StackPane rootPane = new StackPane();
        rootPane.getChildren().addAll(startBtn);

        mainMenuStage.setScene(new Scene(rootPane, 600, 400));

        mainMenuStage.show();
    }
}
