package com.thenikita.witcherreturns.client.savegame;

import com.thenikita.witcherreturns.game.units.Enemy;
import com.thenikita.witcherreturns.game.units.Hero;

import java.util.List;

public class SaveGame {

    public SaveGame(String owner, String pass) {

        this.owner = owner;
        this.pass = pass;
    }

    private String owner;
    private String pass;
    private List<Hero> heroes;
    private List<Enemy> enemies;
    // NPCs' list in future

    public void AddHero(Hero character) {

        heroes.add(character);
    }
}
