package com.thenikita.witcherreturns.game.units;

// This class implements parent class for any behaviouring
// unit int he game such as player, enemy or npc

import java.util.Vector;

abstract public class Unit {

    public Unit(int hp, int en) {

        this.health = hp;
        this.energy = en;
    }

    public String name;
    private int health;
    private int energy;

    private Vector<Integer> position;
    private Vector<Double> speed;

    public void Spawn(Vector<Integer> spawnPoint) {

        this.SetPosition(spawnPoint);
    }

    public void SetPosition(Vector<Integer> position) {

        this.position = position;
    }
    public void SetSpeed(Vector<Double> speed) {

        this.speed = speed;
    }

    public abstract void Attack();

    public abstract void DealDamage();
    public abstract void GetDamaged();

    public abstract void Move();
}
