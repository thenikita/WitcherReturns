package com.thenikita.witcherreturns.game.units;

// This class implements parent class for any behaviouring
// unit int he game such as player, enemy or npc

abstract public class Unit {

    private int health;
    private int energy;

    public abstract void Attack();
}
