package com.thenikita.witcherreturns.game.units;

// This class implements user's character behaviour

import com.thenikita.witcherreturns.client.savegame.Inventory;
import com.thenikita.witcherreturns.game.units.Unit;

import java.util.Vector;

public class Player extends Unit {

    public Player(String name, int health, int energy) {

        super(health, energy);

        this.name = name;

        // TODO add default items
        //inventory.AddItem();
    }

    @Override
    public void SetPosition(Vector<Integer> position) {

    }

    @Override
    public void SetSpeed(Vector<Double> speed) {

    }

    @Override
    public void Attack() {

    }

    @Override
    public void DealDamage() {

    }

    @Override
    public void GetDamaged() {

    }

    @Override
    public void Move() {

    }

    public int gold;

    private Inventory inventory;
}
