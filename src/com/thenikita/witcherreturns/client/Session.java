package com.thenikita.witcherreturns.client;

import com.thenikita.witcherreturns.client.savegame.SaveGame;

import java.util.List;

public class Session {

    public Session() {


    }

    private String userName;
    private String token; // user for server session usage

    public SaveGame save;

    public void InitGameSession(String name, String token, SaveGame save) {

        this.userName = name;

        this.token = token;

        this.save = save;
    }
}
