package com.gildedrose;

import com.gildedrose.updater.ItemUpdater;
import com.gildedrose.updater.ItemUpdaterFactory;

class GildedRose {
    
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();
        for (int i = 0; i < items.length; i++) {
            ItemUpdater itemUpdater = itemUpdaterFactory.createItemUpdater(items[i]);
            itemUpdater.updateItem();
        }
    }
}