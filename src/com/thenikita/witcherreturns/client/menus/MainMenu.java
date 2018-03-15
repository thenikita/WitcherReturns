package com.thenikita.witcherreturns.client.menus;

import com.thenikita.witcherreturns.client.exceptions.NoSavedGameException;
import com.thenikita.witcherreturns.client.savegame.SaveGameWorker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

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

                    SaveGameWorker.LoadOfflineSavedGame();

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
