package com.thenikita.witcherreturns.client.menus;

import com.thenikita.witcherreturns.client.WRClient;
import com.thenikita.witcherreturns.game.Game;
import com.thenikita.witcherreturns.game.units.Hero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import static com.thenikita.witcherreturns.game.Game.DEFAULT_HERO_ENERGY;
import static com.thenikita.witcherreturns.game.Game.DEFAULT_HERO_HP;

public class MainMenu {

    public static void BehaveMainMenu() throws Exception {

        Stage mainMenuStage = new Stage();
        mainMenuStage.setTitle("Main Menu");

        Button startBtn = new Button("New game");
        startBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                System.out.println("Starting new the game...");

                BehaveHeroCreationWindow();

            }
        });

        StackPane rootPane = new StackPane();
        rootPane.getChildren().addAll(startBtn);

        mainMenuStage.setScene(new Scene(rootPane, 600, 400));

        mainMenuStage.show();
    }

    private static void BehaveHeroCreationWindow() {

        Stage createCharacterStage = new Stage();
        createCharacterStage.setTitle("New Character!");

        TextField heroNameField = new TextField();
        Text nameSign = new Text("Character's name");
        nameSign.setWrappingWidth(110);

        Button commitBtn = new Button("Create");
        commitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String newName = heroNameField.getText();

                if (!newName.equals("")) {

                    WRClient.gameSession.save.AddHero(new Hero(newName, DEFAULT_HERO_HP, DEFAULT_HERO_ENERGY));
                    System.out.println("Hero is created!");

                    System.out.println("Game is starting");
                    Game.Start(WRClient.gameSession.save);

                }
            }
        });

        HBox nameBox = new HBox();
        nameBox.getChildren().addAll(nameSign, heroNameField);
        nameBox.setAlignment(Pos.CENTER);

        VBox dataBox = new VBox();
        dataBox.setSpacing(10);
        dataBox.getChildren().addAll(nameBox, commitBtn);
        dataBox.setAlignment(Pos.CENTER);

        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(dataBox);

        createCharacterStage.setScene(new Scene(rootPane, 300, 150));
        createCharacterStage.show();
    }
}
