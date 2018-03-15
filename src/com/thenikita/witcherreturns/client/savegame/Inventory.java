package com.thenikita.witcherreturns.client.savegame;

import com.thenikita.witcherreturns.game.items.Item;

import java.util.List;

public class Inventory {

    private List<Item> items;

    public void ParseInventory() {

        // TODO parse items
        items = null;
    }

    public void AddItem(Item newItem) {

        items.add(newItem);

    }

    public void RemoveItem() {

    }

}
