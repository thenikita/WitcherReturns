package com.thenikita.witcherreturns.client.savegame;
import com.thenikita.witcherreturns.client.WRClient;
import com.thenikita.witcherreturns.client.exceptions.NoSavedGameException;

// This class works on saving/loading games
// even if it's located on server or local

abstract public class SaveGameWorker {

    public static void SaveGame() {

        // TODO: perform saving the game locally or to the server
    }

    public static void LoadOfflineSavedGame() throws NoSavedGameException {

        // TODO: perform loading the game
        // TODO: if no saved game perform throwing exception

        // Session initialization
        //WRClient.gameSession = new Session()

        if (true) {

            throw new NoSavedGameException("Saved game doesn't exist!");
        }
    }

    public static boolean CheckIfLocalSaveExists() {

        return false;
    }

    public static void InitOfflineSave(String name, String pass) {

        // for now we create SaveGame obj and later it also must
        // be saved as json file

        WRClient.gameSession.InitGameSession(name, "0", new SaveGame(name, pass));
        System.out.println("Admin session initiated!");

        // For now it doesn't init offline save
        // TODO implement initialize offline save function

    }

}
