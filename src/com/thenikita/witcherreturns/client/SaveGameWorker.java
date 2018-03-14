package com.thenikita.witcherreturns.client;
import com.thenikita.witcherreturns.client.NoSavedGameException;

// This class works on saving/loading games
// even if it's located on server or local

abstract public class SaveGameWorker {

    public static void SaveGame() {

        // TODO: perform saving the game locally or to the server
    }

    public static void LoadGame() throws NoSavedGameException {

        // TODO: perform loading the game
        // TODO: if no saved game perform throwing exception

        if (true) {

            throw new NoSavedGameException("Saved game doesn't exist!");
        }
    }

    public static boolean CheckIfLocalSaveExists() {

        return false;
    }
}
