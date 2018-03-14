package com.thenikita.witcherreturns.game;

// This class implements current game state, including
// all possible saved data for user and current session
// state as well

import com.thenikita.witcherreturns.client.NoSavedGameException;
import com.thenikita.witcherreturns.client.SaveGameWorker;

public class Game {

    public static void Start() {

        System.out.println("Staring the game...");

        try {

            System.out.println("Trying to load the game...");
            SaveGameWorker.LoadGame();

        } catch (NoSavedGameException e) {

            e.printStackTrace();
        }
    }
}
